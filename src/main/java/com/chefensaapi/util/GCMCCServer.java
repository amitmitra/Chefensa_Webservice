package com.chefensaapi.util;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLSocketFactory;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.PacketInterceptor;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.DefaultPacketExtension;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class GCMCCServer {

	static final String MESSAGE_KEY = "SERVER_MESSAGE";
	private static final Logger logger = Logger.getLogger(GCMCCServer.class
			.getSimpleName());

	public static final String GCM_SERVER = "gcm.googleapis.com";
	public static final int GCM_PORT = 5235;
	public static final String GCM_ELEMENT_NAME = "gcm";
	public static final String GCM_NAMESPACE = "google:mobile:data";

	public static final long GCM_SENDER_ID = 170453453515L;
	public static final String GCM_API_KEY = "AIzaSyDWl546ea2i0zwacfovO_upyIx2yb-ysCc";

	private XMPPConnection connection;
	protected volatile boolean connectionDraining = false;

	public String nextMessageId() {
		return "m-" + UUID.randomUUID().toString();
	}

	public static String createJsonMessage(String to, String messageId,
			Map<String, String> payload, String collapseKey, Long timeToLive,
			Boolean delayWhileIdle) {
		Map<String, Object> message = new HashMap<String, Object>();
		message.put("to", to);
		if (collapseKey != null) {
			message.put("collapse_key", collapseKey);
		}
		if (timeToLive != null) {
			message.put("time_to_live", timeToLive);
		}
		if (delayWhileIdle != null && delayWhileIdle) {
			message.put("delay_while_idle", true);
		}
		message.put("message_id", messageId);
		message.put("data", payload);
		return JSONValue.toJSONString(message);
	}

	protected static String createJsonAck(String to, String messageId) {
		Map<String, Object> message = new HashMap<String, Object>();
		message.put("message_type", "ack");
		message.put("to", to);
		message.put("message_id", messageId);
		return JSONValue.toJSONString(message);
	}

	protected void handleNackReceipt(Map<String, Object> jsonObject) {
		String messageId = (String) jsonObject.get("message_id");
		String from = (String) jsonObject.get("from");
		logger.log(Level.INFO, "handleNackReceipt() from: " + from
				+ ", messageId: " + messageId);
	}

	protected void handleControlMessage(Map<String, Object> jsonObject) {
		logger.log(Level.INFO, "handleControlMessage(): " + jsonObject);
		String controlType = (String) jsonObject.get("control_type");
		if ("CONNECTION_DRAINING".equals(controlType)) {
			connectionDraining = true;
		} else {
			logger.log(Level.INFO,
					"Unrecognized control type: %s. This could happen if new features are "
							+ "added to the CCS protocol.", controlType);
		}
	}

	protected void handleAckReceipt(Map<String, Object> jsonObject) {
		String messageId = (String) jsonObject.get("message_id");
		String from = (String) jsonObject.get("from");
		logger.log(Level.INFO, "handleAckReceipt() from: " + from
				+ ",messageId: " + messageId);
	}

	public void connect() {
		ConnectionConfiguration configuration = new ConnectionConfiguration(
				GCM_SERVER, GCM_PORT);
		configuration.setSecurityMode(SecurityMode.enabled);
		configuration.setReconnectionAllowed(true);
		configuration.setRosterLoadedAtLogin(false);
		configuration.setSendPresence(false);
		configuration.setSocketFactory(SSLSocketFactory.getDefault());

		connection = new XMPPConnection(configuration);
		try {
			connection.connect();
			connection.addConnectionListener(new LoggingConnectionListner());
			connection.addPacketListener(new PacketListener() {

				@Override
				public void processPacket(Packet packet) {
					logger.log(Level.INFO, "Received: " + packet.toString());
					Message incomingMessage = (Message) packet;
					GcmPacketExtension gcmPacket = (GcmPacketExtension) incomingMessage
							.getExtension(GCM_NAMESPACE);
					String json = gcmPacket.getJson();

					try {
						@SuppressWarnings("unchecked")
						Map<String, Object> jsonObject = (Map<String, Object>) JSONValue
								.parseWithException(json);
						Object messageType = jsonObject.get("message_type");
						if (messageType == null) {
							handleUpstreamMessage(jsonObject);

							String messageId = (String) jsonObject
									.get("message_id");
							String from = (String) jsonObject.get("from");
							String ack = createJsonAck(from, messageId);
							send(ack);
						} else if ("ack".equals(messageType.toString())) {
							handleAckReceipt(jsonObject);
						} else if ("nack".equals(messageType.toString())) {
							handleNackReceipt(jsonObject);
						} else if ("control".equals(messageType.toString())) {
							handleControlMessage(jsonObject);
						} else {
							logger.log(Level.WARNING,
									"Unrecognized message type (%s)",
									messageType.toString());
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}, new PacketTypeFilter(Message.class));

			connection.addPacketInterceptor(new PacketInterceptor() {

				@Override
				public void interceptPacket(Packet packet) {
					logger.log(Level.INFO, "Sent: {0}", packet.toXML());
				}
			}, new PacketTypeFilter(Message.class));
			
			connection.login(GCM_SENDER_ID + "@gcm.googleapis.com", GCM_API_KEY);

		} catch (XMPPException e) {
			logger.info("Not able to make XMPPConnection");
			e.printStackTrace();
		}
	}

	protected void send(String jsonRequest) {
		Packet request = new GcmPacketExtension(jsonRequest).toPacket();
		connection.sendPacket(request);
	}

	public boolean sendDownstreamMessage(String jsonRequest) {
		if (!connectionDraining) {
			send(jsonRequest);
			return true;
		}
		logger.info("Dropping downstream message since the connection is draining");
		return false;
	}

	protected void handleUpstreamMessage(Map<String, Object> jsonObject) {
		String category = (String) jsonObject.get("category");
		String from = (String) jsonObject.get("from");
		@SuppressWarnings("unchecked")
		Map<String, String> payload = (Map<String, String>) jsonObject
				.get("data");
		payload.put("ECHO", "Application: " + category);
		String echo = createJsonMessage(from, nextMessageId(), payload,
				"echo:CollapseKey", null, false);
		sendDownstreamMessage(echo);
	}

	private static final class GcmPacketExtension extends
			DefaultPacketExtension {

		private final String json;

		public GcmPacketExtension(String json) {
			super(GCM_ELEMENT_NAME, GCM_NAMESPACE);
			this.json = json;
		}

		public String getJson() {
			return json;
		}

		public Packet toPacket() {
			Message message = new Message();
			message.addExtension(this);
			return message;
		}
	}

	private static final class LoggingConnectionListner implements
			ConnectionListener {

		@Override
		public void connectionClosed() {
			logger.info("Connection closed.");
		}

		@Override
		public void connectionClosedOnError(Exception arg0) {
			logger.info("Connection closed on error.");
		}

		@Override
		public void reconnectingIn(int seconds) {
			logger.log(Level.INFO, "Reconnecting in %d secs", seconds);
		}

		@Override
		public void reconnectionFailed(Exception e) {
			logger.log(Level.INFO, "Reconnection failed.. ", e);
		}

		@Override
		public void reconnectionSuccessful() {
			logger.info("Reconnecting..");
		}

	}
}

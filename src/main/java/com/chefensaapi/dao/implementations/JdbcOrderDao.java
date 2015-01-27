package com.chefensaapi.dao.implementations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.chefensaapi.dao.OrderDao;
import com.chefensaapi.models.Order;

public class JdbcOrderDao implements OrderDao {


	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public final String TABLE_ORDER="order_table";
	public final String ORDER_ID="id";
	public final String DEVICE_ID="deviceId";
	public final String MEAL_ID="mealId";
	public final String ORDER_DATE_TIME="dateTime";
	public final String MEAL_COUNT="mealCount";
	public final String TOTAL_PRICE="totalPrice";
	public final String ORDER_STATUS="status";
	public final String ORDER_ADDRESS="address";
	public final String CUSTOMER_NAME="customerName";
	public final String PHONE_NUMBER="phoneNumber";
	public final String CUSTOMER_EMAIL="customerEmail";
	public final String ORDER_PAYMENT_TYPE="orderPaymentType";
	public final String PANIC_BUTTON_PRESSED="panicButtonPressed";
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;	
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int createOrder(Order order) {
		
	final String INSERT_SQL = "insert into " + TABLE_ORDER +  "(" +
				DEVICE_ID + "," +
				MEAL_ID + ", " +
				ORDER_DATE_TIME + ", " +
				MEAL_COUNT + ", " +
				TOTAL_PRICE + ", " +
				ORDER_STATUS + ", " +
				ORDER_ADDRESS + ", " +
				CUSTOMER_NAME + ", " +
				PHONE_NUMBER + ", " +
				CUSTOMER_EMAIL + ", " + 
				ORDER_PAYMENT_TYPE + ") values ( ? , ? , ? , ? , ? , ? , ? , ?, ?, ?, ?)";
		
		Object[] params = new Object[]{
				order.getDeviceId(),
				order.getMealId(),
				order.getDateTime(),
				order.getMealCount(),
				order.getTotalPrice(),
				order.getStatus(),
				order.getAddress(),
				order.getCustomerName(),
				order.getPhoneNumber(),
				order.getCustomerEmail(),
				order.getOrderPaymentType()
		};
		
		int response = jdbcTemplate.update(INSERT_SQL, params);
		return response;
	}

	@Override
	public List<Order> getOrder(String phoneNumber, String date) {
		/*String sql = "select * from " + TABLE_ORDER + " where " + PHONE_NUMBER
				+ " = ? and " + ORDER_DATET + " = ?";
		List<Order> orders = jdbcTemplate.query(sql, new Object[] { phoneNumber,
				date }, new OrderRowMapper());*/
		return null;
	}

	@Override
	public Order getOrder(String phoneNumber, String date, String time) {
		/*String sql = "select * from " + TABLE_ORDER + " where " + PHONE_NUMBER
				+ " = ? and " + ORDER_DATE + " = ? and " + ORDER_TIME + " = ?";
		Order order = jdbcTemplate.queryForObject(sql, new Object[] {
				phoneNumber, date }, new OrderRowMapper());*/
		return null;
	}
	
	public class OrderRowMapper implements RowMapper<Order> {
		@Override
		public Order mapRow(ResultSet rs, int arg1) throws SQLException {
			Order order = new Order(rs.getLong(ORDER_ID),
					rs.getString(DEVICE_ID), rs.getString(MEAL_ID),
					rs.getLong(ORDER_DATE_TIME), rs.getString(MEAL_COUNT),
					rs.getInt(TOTAL_PRICE), rs.getInt(ORDER_STATUS),
					rs.getString(ORDER_ADDRESS), rs.getString(CUSTOMER_NAME),
					rs.getLong(PHONE_NUMBER), rs.getString(CUSTOMER_EMAIL),
					rs.getInt(ORDER_PAYMENT_TYPE),
					rs.getInt(PANIC_BUTTON_PRESSED));
			return order;
		}
	}

}

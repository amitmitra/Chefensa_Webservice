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
	
	public final String TABLE_ORDER="order";
	public final String ORDER_ID="orderId";
	public final String CUSTOMER_ID="customerId";
	public final String MEAL_ID="mealId";
	public final String ADDRESS_ID="addressId";
	public final String ORDER_DATE="orderDate";
	public final String ORDER_TIME="orderTime";
	public final String MEAL_QUANTITY="mealQuantity";
	public final String STATUS="status";
	public final String RATING="rating";
	public final String PANIC_BUTTON_PRESSED="panicButtonPressed";
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;	
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int createOrder(Order order) {
		
	final String INSERT_SQL = "insert into" + TABLE_ORDER +  "(" +
				ORDER_ID + ", " +
				CUSTOMER_ID + ", " +
				MEAL_ID + ", " +
				ADDRESS_ID + ", " +
				ORDER_DATE + ", " +
				ORDER_TIME + ", " +
				MEAL_QUANTITY + ", " + 
				STATUS + ",) values ( ? , ? , ? , ? , ? , ? , ? , ? )";
		
		Object[] params = new Object[]{
				order.getOrderId(),
				order.getCustomerId(),
				order.getMealId(),
				order.getAddressId(),
				order.getOrderDate(),
				order.getOrderTime(),
				order.getMealQuantity(),
				order.getStatus()
		};
		
		int response = jdbcTemplate.update(INSERT_SQL, params);
		return response;
	}

	@Override
	public List<Order> getOrder(long customerId, String date) {
		String sql = "select * from " + TABLE_ORDER + " where " + CUSTOMER_ID
				+ " = ? and " + ORDER_DATE + " = ?";
		List<Order> orders = jdbcTemplate.query(sql, new Object[] { customerId,
				date }, new OrderRowMapper());
		return orders;
	}

	@Override
	public Order getOrder(long customerId, String date, String time) {
		String sql = "select * from " + TABLE_ORDER + " where " + CUSTOMER_ID
				+ " = ? and " + ORDER_DATE + " = ? and " + ORDER_TIME + " = ?";
		Order order = jdbcTemplate.queryForObject(sql, new Object[] {
				customerId, date }, new OrderRowMapper());
		return order;
	}
	
	public class OrderRowMapper implements RowMapper<Order> {
		@Override
		public Order mapRow(ResultSet rs, int arg1) throws SQLException {
			Order order = new Order(rs.getLong(ORDER_ID),
					rs.getLong(CUSTOMER_ID), rs.getLong(ADDRESS_ID),
					rs.getString(ORDER_DATE), rs.getString(ORDER_TIME),
					rs.getString(MEAL_ID), rs.getString(MEAL_QUANTITY),
					rs.getInt(STATUS), rs.getFloat(RATING), rs.getInt(PANIC_BUTTON_PRESSED));
			return order;
		}
	}

}

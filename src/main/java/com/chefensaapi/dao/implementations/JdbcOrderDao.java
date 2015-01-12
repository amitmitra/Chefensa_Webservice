package com.chefensaapi.dao.implementations;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.chefensaapi.dao.OrderDao;
import com.chefensaapi.models.Order;

public class JdbcOrderDao implements OrderDao {


	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public final String ORDER_ID="orderId";
	public final String CUSTOMER_ID="customerId";
	public final String MEAL_ID="mealId";
	public final String CUSTOMER_NAME="customerName";
	public final String ORDER_ADDRESS="orderAddress";
	public final String ORDER_PHONE="orderPhone";
	public final String CHEF_ID="chefId";
	public final String ORDER_COST="orderCost";
	public final String ORDER_TIME="orderTime";
	
	public final String INSERT_SQL = "insert into OrderPlaced (" +  
			CUSTOMER_ID + ", " +
			MEAL_ID + ", " +
			CUSTOMER_NAME + ", " +
			ORDER_ADDRESS + ", " +
			ORDER_PHONE + ", " +
			CHEF_ID + ", " +
			ORDER_COST + ", " +
			ORDER_TIME + ") " +
			"values ( ? , ? , ? , ? , ? , ? , ? , ? )";
	
	
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;	
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int createOrder(Order order) {
		Object[] params = new Object[]{
				order.getCustomerId(),
				order.getMealId(),
				order.getCustomerName(),
				order.getOrderAddress(),
				order.getOrderPhone(),
				order.getChefId(),
				order.getOrderCost(),
				order.getOrderTime()
		};
		
		
//[insert into Customer (customer_name, deviceId, gender, mealType, primaryPhoneNo, secondaryPhoneNo, primaryEmailId, secondaryEmailId, primaryAddress, secondaryAddress, cuisinePreference, spicinessPreference, profileImageUrl, totalHitsOnApp, totalOrdersPlaced, dateOfBirth)  values ( ? , ? , ? , ? , ? , ? , ? , ?, ? ,? , ? , ?, ? , ? , ? , ? )]	
//[insert into Order (customerId, mealId, customerName, orderAddress, orderPhone, chefId, orderCost, orderTime) values ( ? , ? , ? , ? , ? , ? , ? , ? )]		
		/*{
	"orderId": "1",
	"customerId": "1",
	"mealId": "1",
	"chefId": "1",
	"customerName": "harsh",
	"orderCost": "20",
	"orderAddress": "gfdsa",
	"orderPhone": "12345",
	"orderTime": "12345"
	}*/
		int response = jdbcTemplate.update(INSERT_SQL, params);
		//int response1 = jdbcTemplate.update("insert into chefensa.`Order` (customerId, mealId, customerName, orderAddress, orderPhone, chefId, orderCost, orderTime) values (1, 12 ,22, 234, 234 , 21 , 20 , 23 )");
		return response;
	}

}

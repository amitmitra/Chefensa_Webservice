package com.chefensaapi.dao.implementations;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.chefensaapi.dao.CustomerDao;
import com.chefensaapi.models.Customer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcCustomerDao implements CustomerDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public final String TABLE_CUSTOMER = "customer";
	public final String CUSTOMER_ID = "id";
	public final String CUSTOMER_DEVICEID = "deviceId";
	public final String CUSTOMER_NAME = "customerName";
	public final String CUSTOMER_PRIMARY_PHONE = "primaryPhone";
	public final String CUSTOMER_SECONDARY_PHONE = "secondaryPhone";
	public final String CUSTOMER_PRIMARY_EMAIL = "primaryEmail";
	public final String CUSTOMER_SECONDARY_EMAIL = "secondaryEmail";
	public final String CUSTOMER_TOTAL_HITS_ON_APP = "totalHitsOnApp";
	public final String CUSTOMER_TOTAL_ORDERS = "noOfTImesOrdered";
	public final String CUSTOMER_STAYING_MORE_THAN_2_MIN_COUNT = "timesStayingMoreThan2Mins";
	public final String CUSTOMER_GCM_ID = "gcmId";

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public long create(Customer customer) {

		String INSERT_SQL = "insert into " + TABLE_CUSTOMER + "("
				+ CUSTOMER_DEVICEID + ", " + CUSTOMER_NAME + ", "
				+ CUSTOMER_PRIMARY_PHONE + ", " + CUSTOMER_SECONDARY_PHONE
				+ ", " + CUSTOMER_PRIMARY_EMAIL + ", "
				+ CUSTOMER_SECONDARY_EMAIL + ", " + CUSTOMER_TOTAL_HITS_ON_APP
				+ ", " + CUSTOMER_TOTAL_ORDERS + ", "
				+ CUSTOMER_STAYING_MORE_THAN_2_MIN_COUNT + ") "
				+ " values ( ? , ? , ? , ? , ? , ? , ? , ?, ?)";

		Object[] params = new Object[] { customer.getDeviceId(),
				customer.getCustomerName(), customer.getPrimaryPhone(),
				customer.getSecondaryPhone(), customer.getPrimaryEmail(),
				customer.getSecondaryEmail(), customer.getTotalHitsOnApp(),
				customer.getNoOfTImesOrdered(),
				customer.getTimesStayingMoreThan2Mins() };

		int response = jdbcTemplate.update(INSERT_SQL, params);
		
		Customer cust=jdbcTemplate.queryForObject("select max(id) from customer",null,new CustomerMapper());
		long id=-1;
		if(cust!=null){
			id=cust.getId();
		}
	
		System.out.println("Inserted into Customer Table Successfully");
		return id;
	}
	
	public Customer getCustomerInfo(long customerId) {
		Customer customer = null;
		String queryCustomer = "select * from Customer where " + CUSTOMER_ID
				+ " = ?";

		customer = jdbcTemplate.queryForObject(queryCustomer,
				new Object[] { customerId }, new CustomerMapper());
		return customer;
	}

	public class CustomerMapper implements RowMapper<Customer> {

		public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
			Customer customer = new Customer(rs.getLong(CUSTOMER_ID),
					rs.getString(CUSTOMER_DEVICEID),
					rs.getString(CUSTOMER_NAME),
					rs.getString(CUSTOMER_PRIMARY_PHONE),
					rs.getString(CUSTOMER_SECONDARY_PHONE),
					rs.getString(CUSTOMER_PRIMARY_EMAIL),
					rs.getString(CUSTOMER_SECONDARY_EMAIL),
					rs.getLong(CUSTOMER_TOTAL_HITS_ON_APP),
					rs.getLong(CUSTOMER_TOTAL_ORDERS),
					rs.getLong(CUSTOMER_STAYING_MORE_THAN_2_MIN_COUNT));
			return customer;
		}

	}

}

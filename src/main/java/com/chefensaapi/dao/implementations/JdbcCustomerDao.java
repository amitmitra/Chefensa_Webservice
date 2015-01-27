package com.chefensaapi.dao.implementations;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.chefensaapi.dao.CustomerDao;
import com.chefensaapi.models.Customer;

@SuppressWarnings("deprecation")
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
				+ CUSTOMER_SECONDARY_EMAIL  + ", " + CUSTOMER_TOTAL_HITS_ON_APP + ", "+ CUSTOMER_GCM_ID
				+ ") " + " values ( ? , ? , ? , ? , ? , ? , ?, ?)";

		Object[] params = new Object[] { customer.getDeviceId(),
				customer.getCustomerName(), customer.getPrimaryPhone(),
				customer.getSecondaryPhone(), customer.getPrimaryEmail(),
				customer.getSecondaryEmail(), 1, customer.getGcmId()};

		int response = jdbcTemplate.update(INSERT_SQL, params);

		long id = jdbcTemplate.queryForLong("select max(id) from customer");

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
	
	public boolean customerExist(String deviceId){
		Customer customer = null;
		String queryCustomer = "select count(1) from " + TABLE_CUSTOMER + " where " + CUSTOMER_DEVICEID + " = " + deviceId;
		int count = jdbcTemplate.queryForInt(queryCustomer);
		if(count == 0){
			return false;
		} else {
		return true;
		}
	}
	
	public long updateCustomer(String deviceId, Customer customer) {
		String sql = "update " + TABLE_CUSTOMER + " set " + CUSTOMER_GCM_ID
				+ " = '" + customer.getGcmId() + "' where " + CUSTOMER_DEVICEID
				+ " = " + deviceId;
		jdbcTemplate.update(sql);
		long customerId = jdbcTemplate.queryForLong("select " + CUSTOMER_ID
				+ " from " + TABLE_CUSTOMER + " where " + CUSTOMER_DEVICEID + " = " + deviceId);
		return customerId;
	}
	
	public int increaseHitsCount(String deviceId){
		long count = jdbcTemplate.queryForLong("select " + CUSTOMER_TOTAL_HITS_ON_APP + " from " + TABLE_CUSTOMER + " where "
				+ CUSTOMER_DEVICEID + " = " + deviceId);
		String sql = "update " + TABLE_CUSTOMER + " set " + CUSTOMER_TOTAL_HITS_ON_APP
				+ " = " + (count+1) + " where " + CUSTOMER_DEVICEID + " = " + deviceId;
		return jdbcTemplate.update(sql);
	}

	public class CustomerMapper implements RowMapper<Customer> {

		public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
			Customer customer = new Customer(rs.getLong(CUSTOMER_ID),
					rs.getString(CUSTOMER_DEVICEID),
					rs.getString(CUSTOMER_NAME),
					rs.getLong(CUSTOMER_PRIMARY_PHONE),
					rs.getLong(CUSTOMER_SECONDARY_PHONE),
					rs.getString(CUSTOMER_PRIMARY_EMAIL),
					rs.getString(CUSTOMER_SECONDARY_EMAIL),
					rs.getLong(CUSTOMER_TOTAL_HITS_ON_APP),
					rs.getLong(CUSTOMER_TOTAL_ORDERS),
					rs.getLong(CUSTOMER_STAYING_MORE_THAN_2_MIN_COUNT),
					rs.getString(CUSTOMER_GCM_ID));
			return customer;
		}

	}

}

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
	
	public final String CUSTOMER_ID ="customerId";
	public final String CUSTOMER_NAME="customer_name";
	public final String CUSTOMER_DEVICEID="deviceId";
	public final String CUSTOMER_GENDER="gender";
	public final String CUSTOMER_MEALTYPE="mealType";
	public final String CUSTOMER_PRIMARY_PHONE="primaryPhoneNo";
	public final String CUSTOMER_SECONDARY_PHONE="secondaryPhoneNo";
	public final String CUSTOMER_PRIMARY_EMAIL="primaryEmailId";
	public final String CUSTOMER_SECONDARY_EMAIL="secondaryEmailId";
	public final String CUSTOMER_PRIMARY_ADDRESS="primaryAddress";
	public final String CUSTOMER_SECONDARY_ADDRESS="secondaryAddress";
	public final String CUSTOMER_CUISINE_PREFERENCE="cuisinePreference";
	public final String CUSTOMER_SPICINESS_PREFERENCE="spicinessPreference";
	public final String CUSTOMER_PROFILE_IMAGE_URL="profileImageUrl";
	public final String CUSTOMER_TOTAL_HITS_ON_APP="totalHitsOnApp";
	public final String CUSTOMER_TOTAL_ORDERS="totalOrdersPlaced";
	public final String CUSTOMER_DATE_OF_BIRTH="dateOfBirth";
	
	

	public final String INSERT_SQL = "insert into Customer ("
			+ CUSTOMER_NAME + ", " +
			 CUSTOMER_DEVICEID + ", " +
			 CUSTOMER_GENDER + ", " +
			 CUSTOMER_MEALTYPE + ", " +
			 CUSTOMER_PRIMARY_PHONE + ", " +
			 CUSTOMER_SECONDARY_PHONE + ", " +
			 CUSTOMER_PRIMARY_EMAIL + ", " +
			 CUSTOMER_SECONDARY_EMAIL + ", " +
			 CUSTOMER_PRIMARY_ADDRESS + ", " +
			 CUSTOMER_SECONDARY_ADDRESS + ", " +
			 CUSTOMER_CUISINE_PREFERENCE + ", " +
			 CUSTOMER_SPICINESS_PREFERENCE + ", " +
			 CUSTOMER_PROFILE_IMAGE_URL + ", " +
			 CUSTOMER_TOTAL_HITS_ON_APP + ", " +
			 CUSTOMER_TOTAL_ORDERS + ", " +
			 CUSTOMER_DATE_OF_BIRTH + ") " +
			" values ( ? , ? , ? , ? , ? , ? , ? , ?, ? ,? , ? , ?, ? , ? , ? , ? )";
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;	
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int create(Customer customer) {
		//String queryCustomer = "insert into Customer (" + CUSTOMER_ID + "," +  CUSTOMER_NAME + ") values (?,?)";
		String queryCustomer = "insert into Customer (" + CUSTOMER_ID + "," +  CUSTOMER_NAME + ") values (?,?)";
        Object[] params = new Object[] {
        		customer.getCustomerName(),
        		customer.getDeviceId(),
        		customer.getGender(),
        		customer.getMealType(),
        		customer.getPrimaryPhoneNo(),
        		customer.getSecondaryPhoneNo(),
        		customer.getPrimaryEmailId(),
        		customer.getSecondaryEmailId(),
        		customer.getPrimaryAddress(),
        		customer.getSecondaryAddress(),
        		customer.getCuisinePreference(),
        		customer.getSpicinessPreference(),
        		customer.getProfileImageUrl(),
        		customer.getTotalHitsOnApp(),
        		customer.getTotalOrdersPlaced(),
        		customer.getDateOfBirth()};
		
		int response=jdbcTemplate.update(INSERT_SQL, params);
        System.out.println("Inserted into Customer Table Successfully");
        return response;
	}
	
	public Customer getCustomerInfo(long customerId){
		Customer customer = null;
		String queryCustomer = "select * from Customer where " + CUSTOMER_ID +  " = ?";
		
		customer = jdbcTemplate.queryForObject(queryCustomer, new Object[]{customerId},new CustomerMapper() );
		return customer;
	}
	

public class CustomerMapper implements RowMapper<Customer>{

	public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
		Customer customer = new Customer();
		customer.setCustomerId(rs.getInt(CUSTOMER_ID));
		customer.setCustomerName(rs.getString(CUSTOMER_NAME));
		customer.setDeviceId(rs.getString(CUSTOMER_DEVICEID));
		customer.setGender(rs.getString(CUSTOMER_GENDER));
		customer.setMealType(rs.getString(CUSTOMER_MEALTYPE));
		customer.setPrimaryAddress(rs.getString(CUSTOMER_PRIMARY_ADDRESS));
		customer.setCuisinePreference(rs.getString(CUSTOMER_CUISINE_PREFERENCE));
		customer.setSecondaryAddress(rs.getString(CUSTOMER_SECONDARY_ADDRESS));
		customer.setPrimaryEmailId(rs.getString(CUSTOMER_PRIMARY_EMAIL));
		customer.setSecondaryEmailId(rs.getString(CUSTOMER_SECONDARY_EMAIL));
		customer.setPrimaryPhoneNo(rs.getString(CUSTOMER_PRIMARY_PHONE));
		customer.setSecondaryPhoneNo(rs.getString(CUSTOMER_SECONDARY_PHONE));
		customer.setSpicinessPreference(rs.getString(CUSTOMER_SPICINESS_PREFERENCE));
		customer.setTotalHitsOnApp(rs.getInt(CUSTOMER_TOTAL_HITS_ON_APP));
		customer.setTotalOrdersPlaced(rs.getInt(CUSTOMER_TOTAL_ORDERS));
		customer.setDateOfBirth(rs.getString(CUSTOMER_DATE_OF_BIRTH));
		return customer;
	}
	
}


}

package com.chefensaapi.dao.implementations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.chefensaapi.dao.ChefDao;
import com.chefensaapi.models.Chef;

public class JdbcChefDao implements ChefDao {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public final String TABLE_CHEF="chef";
	public final String CHEF_ID="id";
	public final String CHEF_NAME="name";
	public final String CHEF_GENDER="gender";
	public final String CHEF_PHONE_NUMBER="phoneNumber";
	public final String CHEF_EMAIL="email";
	public final String ADDRESS_ID="addressId";
	public final String CHEF_IMAGE_URL="imageUrl";
	public final String CHEF_DESCRIPTION="description";
	public final String CHEF_LANGUAGES="languages";
	public final String CHEF_MARITAL_STATUS="maritalStatus";
	public final String CHEF_ETHNICITY="ethnicity";
	public final String CHEF_CATEGORY="chefCategory";
	public final String CHEF_MEAL_CATEGORY="mealCategory";
	public final String CHEF_WORKING_DAYS="workingDays";
	public final String CHEF_WORKING_TIME="workingTime";
	public final String CHEF_MEAL_TYPES="mealTypes";
	public final String CHEF_SPECIALITY="speciality";
	public final String CHEF_RATING="rating";
	public final String CHEF_CAPACITY="capacity";
	public final String CHEF_EXPERIENCE="experience";
	public final String CHEF_CREATED_TIME="createTime";
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Chef> getChefsList(){
		String query = "select * from " + TABLE_CHEF;
		List<Chef> chefs = jdbcTemplate.query(query, new ChefMapper());
		return chefs;
	}

	public Chef getChefInfo(long chef_id) {
		Chef chef;
		String query = "select * from Chef where " + CHEF_ID + " = ?";
		chef = jdbcTemplate.queryForObject(query, new Object[]{chef_id}, new ChefMapper());
		return chef;
	}
	
	@Override
	public long addChefInfo(Chef chef) {
		String insertQuery = "insert into " + TABLE_CHEF + " ("
				+ CHEF_NAME + ", " + CHEF_GENDER + ", " + CHEF_PHONE_NUMBER
				+ ", " + CHEF_EMAIL + ", " + ADDRESS_ID + ", " + CHEF_IMAGE_URL
				+ ", " + CHEF_DESCRIPTION + ", " + CHEF_LANGUAGES + ", "
				+ CHEF_MARITAL_STATUS + ", " + CHEF_ETHNICITY + ", "
				+ CHEF_CATEGORY + ", " + CHEF_MEAL_CATEGORY + ", "
				+ CHEF_WORKING_DAYS + ", " + CHEF_WORKING_TIME + ", "
				+ CHEF_MEAL_TYPES + ", " + CHEF_SPECIALITY + ", "
				+ CHEF_CAPACITY + ") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		// define query arguments
		final Object[] params = new Object[] {chef.getChefName(),
				chef.getGender(), chef.getPhoneNumber(), chef.getEmailId(),
				chef.getAddressId(), chef.getChefImageUrl(),
				chef.getChefDescription(), chef.getLanguages(),
				chef.getMaritalStatus(), chef.getEthnicity(),
				chef.getChefCategory(), chef.getMealCategory(),
				chef.getWorkingDays(), chef.getWorkingTime(),
				chef.getMealTypes(), chef.getChefSpeciality(),
				chef.getCapacity()};
		
		jdbcTemplate.update(insertQuery, params);
		
		Long id = jdbcTemplate.queryForLong("SELECT max(id) from " + TABLE_CHEF);

		return id;
	}
	
	public class ChefMapper implements RowMapper<Chef>{

		public Chef mapRow(ResultSet rs, int arg1) throws SQLException {
			Chef chef = new Chef(rs.getLong(CHEF_ID), rs.getString(CHEF_NAME), rs.getInt(CHEF_GENDER), rs.getString(CHEF_PHONE_NUMBER),
					rs.getString(CHEF_EMAIL), rs.getLong(ADDRESS_ID), rs.getString(CHEF_IMAGE_URL), rs.getString(CHEF_DESCRIPTION), 
					rs.getString(CHEF_LANGUAGES), rs.getInt(CHEF_MARITAL_STATUS), rs.getString(CHEF_ETHNICITY), rs.getInt(CHEF_CATEGORY),
					rs.getInt(CHEF_MEAL_CATEGORY), rs.getString(CHEF_WORKING_DAYS), rs.getInt(CHEF_WORKING_TIME), 
					rs.getString(CHEF_MEAL_TYPES), rs.getString(CHEF_SPECIALITY), rs.getString(CHEF_RATING), rs.getInt(CHEF_CAPACITY),
					rs.getInt(CHEF_EXPERIENCE), rs.getLong(CHEF_CREATED_TIME));
			
			return chef;
		}	
	}
}

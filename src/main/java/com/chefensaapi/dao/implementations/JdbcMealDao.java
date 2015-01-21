package com.chefensaapi.dao.implementations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.chefensaapi.dao.MealDao;
import com.chefensaapi.models.Meal;

public class JdbcMealDao implements MealDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public final String MEAL_TABLE = "meal";
	public final String MEAL_ID = "mealId";
	public final String MEAL_NAME = "mealName";
	public final String MEAL_CONTENT = "mealContent";
	public final String MEAL_DESCRIPTION = "mealDescription";
	public final String MEAL_TYPE = "mealType";
	public final String MEAL_CATEGORY = "mealCategory";
	public final String MEAL_NOTE = "mealNote";
	public final String MEAL_NUTRIENTS = "mealNutrients";
	public final String MEAL_IMAGE_URL = "mealImageUrl";
	public final String MEAL_CHEF_NAME = "chefName";
	public final String MEAL_CHEF_IMAGE_URL = "chefImageUrl";
	public final String MEAL_CHEF_ID = "chefId";
	public final String MEAL_SPICINESS = "spicyness";
	public final String MEAL_PRICE = "mealPrice";
	public final String MEAL_RATING = "rating";
	public final String MEAL_TOTAL_ORDERED = "totalMealsOrdered";
	
	public final String MEAL_DATE = "mealDate";
	public final String MEAL_TIME = "mealTime";
	public final String MEAL_QUANTIRY = "mealQuantity";
	public final String MEAL_AVAILABILITY = "availability";

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public long addMealInfo(Meal meal) {

		String insertQuery = "insert into " + MEAL_TABLE + "(" + MEAL_NAME
				+ ", " + MEAL_CONTENT + ", " + MEAL_DESCRIPTION + ", "
				+ MEAL_TYPE + ", " + MEAL_CATEGORY + ", " + MEAL_NOTE + ", "
				+ MEAL_NUTRIENTS + ", " + MEAL_IMAGE_URL + ", "
				+ MEAL_CHEF_NAME + ", " + MEAL_CHEF_IMAGE_URL + ", "
				+ MEAL_CHEF_ID + ", " + MEAL_SPICINESS + ", " + MEAL_PRICE
				+ MEAL_DATE + ", " + MEAL_TIME + ", " + MEAL_QUANTIRY + ", "
				+ MEAL_AVAILABILITY + ", "
				+ ") values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		Object[] params = new Object[] { meal.getMealName(),
				meal.getMealContent(), meal.getMealDescription(),
				meal.getMealType(), meal.getMealCategory(), meal.getMealNote(),
				meal.getMealNutrients(), meal.getMealImageUrl(),
				meal.getChefName(), meal.getChefImageUrl(), meal.getChefId(),
				meal.getSpicyness(), meal.getMealPrice() };

		jdbcTemplate.update(insertQuery, params);

		return jdbcTemplate.queryForLong("SELECT max(" + MEAL_ID + ") from " + MEAL_TABLE);
	}

	public List<Meal> getMealOnDate(String date) {
		String sql = "select * from " + MEAL_TABLE + " where " + MEAL_DATE + " = ?";

		List<Meal> mealList = jdbcTemplate.query(sql, new Object[] { date }, new MealRowMapper());

		return mealList;
	}

	public Meal getMealWithId(long mealId) {
		String sql = "select * from Meal where " + MEAL_ID + " =?";
		Meal meal = jdbcTemplate.queryForObject(sql, new Object[] { mealId },
				new MealRowMapper());
		return meal;
	}

	public class MealRowMapper implements RowMapper<Meal> {
		public Meal mapRow(ResultSet rs, int arg1) throws SQLException {
			Meal meal = new Meal(rs.getLong(MEAL_ID), rs.getString(MEAL_NAME),
					rs.getString(MEAL_CONTENT), rs.getString(MEAL_DESCRIPTION),
					rs.getString(MEAL_TYPE), rs.getInt(MEAL_CATEGORY),
					rs.getString(MEAL_NOTE), rs.getString(MEAL_NUTRIENTS),
					rs.getString(MEAL_IMAGE_URL), rs.getString(MEAL_CHEF_NAME),
					rs.getString(MEAL_CHEF_IMAGE_URL),
					rs.getLong(MEAL_CHEF_ID), rs.getInt(MEAL_SPICINESS),
					rs.getInt(MEAL_PRICE), rs.getFloat(MEAL_RATING), rs.getString(MEAL_DATE), rs.getInt(MEAL_TIME), rs.getInt(MEAL_QUANTIRY),
					rs.getInt(MEAL_AVAILABILITY));
			return meal;
		}
	}

}

package com.chefensaapi.dao.implementations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.chefensaapi.dao.MealDao;
import com.chefensaapi.models.Meal;
import com.chefensaapi.models.Menu;

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

	public final String MENU_TABLE = "menu";
	public final String MENU_MEAL_ID = "mealId";
	public final String MENU_MEAL_DATE = "mealDate";
	public final String MENU_MEAL_TIME = "mealTime";
	public final String MENU_MEAL_QUANTIRY = "mealQuantity";
	public final String MENU_AVAILABILITY = "availability";

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

	public void addMenuInfo(Menu menu) {

		String insetQuery = "insert into " + MENU_TABLE + "(" + MENU_MEAL_ID
				+ ", " + MENU_MEAL_DATE + ", " + MENU_MEAL_TIME + ", "
				+ MENU_MEAL_QUANTIRY + ", " + MENU_AVAILABILITY
				+ ") values (?,?,?,?,?)";
		Object[] params = new Object[] { menu.getMealId(), menu.getMealDate(),
				menu.getMealTime(), menu.getMealQuantity(),
				menu.getAvailability() };

		jdbcTemplate.update(insetQuery, params);
	}

	public List<Meal> getMealOnDate(String date) {
		String sql = "select * from " + MEAL_TABLE + " where " + MEAL_ID
				+ " in (select " + MENU_MEAL_ID + " from " + MENU_TABLE
				+ " where " + MENU_MEAL_DATE + " = ?";

		List<Meal> mealList = jdbcTemplate.query(sql, new Object[] { date },
				new MealRowMapper());

		return mealList;
	}

	public Meal getMealWithId(long mealId) {
		String sql = "select * from Meal where " + MEAL_ID + " =?";
		Meal meal = jdbcTemplate.queryForObject(sql, new Object[] { mealId },
				new MealRowMapper());
		return meal;
	}

	@Override
	public List<Menu> getMealAvailability(String date) {
		String sql = "select * from " + MENU_TABLE + " where " + MENU_MEAL_DATE
				+ " = ?";
		List<Menu> mealAvailabilityList = jdbcTemplate.query(sql,
				new Object[] { date }, new MenuRowMapper());
		return mealAvailabilityList;
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
					rs.getInt(MEAL_PRICE), rs.getFloat(MEAL_RATING),
					rs.getLong(MEAL_TOTAL_ORDERED));
			return meal;
		}
	}

	public class MenuRowMapper implements RowMapper<Menu> {
		@Override
		public Menu mapRow(ResultSet rs, int arg1) throws SQLException {
			Menu menu = new Menu(rs.getLong(MENU_MEAL_ID),
					rs.getString(MENU_MEAL_DATE), rs.getString(MENU_MEAL_TIME),
					rs.getInt(MENU_MEAL_QUANTIRY), rs.getInt(MENU_AVAILABILITY));
			return menu;
		}
	}

}

package com.chefensaapi.dao.implementations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.chefensaapi.dao.AddressDao;
import com.chefensaapi.models.Address;

public class JdbcAddressDao implements AddressDao{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public final String TABLE_ADDRESS = "address";
	public final String ADDRESS_ID = "id";
	public final String ADDRESS_COUNTRY = "country";
	public final String ADDRESS_STATE = "state";
	public final String ADDRESS_CITY = "city";
	public final String ADDRESS_LOCALITY = "locality";
	public final String ADDRESS_PIN = "pin";
	public final String ADDRESS_INITIAL = "initialAddress";
	public final String ADDRESS_LANDMARK = "landmark";
	private final String ADDRESS_COORDINATES = "coordinates"; 
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public long saveAddress(Address address) {
		final String query = "insert into " + TABLE_ADDRESS + "("
				+ ADDRESS_COUNTRY + ", " + ADDRESS_STATE + ", " + ADDRESS_CITY
				+ ", " + ADDRESS_LOCALITY + ", " + ADDRESS_PIN + ", "
				+ ADDRESS_INITIAL + ", " + ADDRESS_LANDMARK + ", "
				+ ADDRESS_COORDINATES + ") values (?,?,?,?,?,?,?,?)";

		final Object[] params = new Object[] { address.getCountry(),
				address.getState(), address.getCity(), address.getLocality(),
				address.getPin(), address.getInitialAddress(),
				address.getLandmark(), address.getCoordinates() };

		jdbcTemplate.update(query, params);
		Long id = jdbcTemplate.queryForLong("SELECT max(id) from " + TABLE_ADDRESS);

		return id;
	}

	@Override
	public Address getAddress(long addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> getAllAddress() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public class AddressMapper implements RowMapper<Address>{

		@Override
		public Address mapRow(ResultSet rs, int arg1) throws SQLException {
			Address address = new Address(rs.getLong(ADDRESS_ID),
					rs.getString(ADDRESS_COUNTRY), rs.getString(ADDRESS_STATE),
					rs.getString(ADDRESS_CITY), rs.getString(ADDRESS_LOCALITY),
					rs.getString(ADDRESS_PIN), rs.getString(ADDRESS_INITIAL),
					rs.getString(ADDRESS_LANDMARK),
					rs.getString(ADDRESS_COORDINATES));
			return address;
		}
		
	}

}
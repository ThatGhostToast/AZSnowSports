package com.azsnowsports.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import com.azsnowsports.model.UserModel;

@Service
public class UserDataService implements UserDataAccessInterface<UserModel>{
	@SuppressWarnings("unused")
	@Autowired
	private DataSource datasource;
	private JdbcTemplate jdbcTemplateObject;
	
	public UserDataService(DataSource dataSource)
	{
		this.datasource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Method used to find a user in the database by their username
	 * @param username the username that we're using to search the database
	 */
	@Override
	public UserModel findByUsername(UserModel username) {
		String sql = "SELECT * FROM Users WHERE USERNAME = '" + username.getUsername() + "'";
		try
		{
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			if (srs.next())
			{
				UserModel foundUser = new UserModel(srs.getString("FIRSTNAME"), srs.getString("LASTNAME"), srs.getString("EMAIL"), srs.getString("ADDRESS"), srs.getLong("PHONENUMBER"), srs.getString("USERNAME"), srs.getString("PASSWORD"));
				return foundUser;		
			}
		} catch (Exception e)
		{
			System.out.println("ERROR IN THE SQL, " + sql);
		}
		return null;
	}
	
	@Override
	public UserModel createUser(UserModel newUser)
	{
		String sql = "INSERT INTO Users(`FIRSTNAME`, `LASTNAME`, `EMAIL`, `ADDRESS`, `PHONENUMBER`, `USERNAME`, `PASSWORD`)VALUES(?, ?, ?, ?, ?, ?, ?)";
		try
		{
			//Execute SQL insert 
			int rows = jdbcTemplateObject.update(sql, newUser.getFirstName(), newUser.getLastName(), newUser.getEmail(), newUser.getAddress(), newUser.getPhoneNumber(), newUser.getUsername(), newUser.getPassword());
			
			if (rows == 0)
			{
				System.out.println("ERROR: USER NOT CREATED");
				return null;
			}
			
			//Return the results of the insert
			return findByUsername(newUser);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean login(UserModel user) {
		String sql = "SELECT * FROM Users WHERE USERNAME = '" + user.getUsername() + "' AND PASSWORD = '" + user.getPassword() + "'";
		try
		{
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			if (srs.next())
			{
				return true;
			}
		} catch (Exception e)
		{
			System.out.println("ERROR IN THE SQL, " + sql);
		}
		return false;
	}

}

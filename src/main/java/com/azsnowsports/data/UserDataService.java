package com.azsnowsports.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import com.azsnowsports.model.UserModel;

/**
 * @author Zac Almas and Austin Driver
 *
 *         Data service used for user data access
 */
@Service
public class UserDataService implements UserDataAccessInterface<UserModel> {
	/**
	 * Datasource used for the connection
	 */
	@SuppressWarnings("unused")
	@Autowired
	private DataSource datasource;
	/**
	 * JDBC Object used to execute sql queries
	 */
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * Temporary variable used to get the user's username around the site This is
	 * going to be removed and replaced with a session variable
	 */
	public static String currentUserUsername;

	/**
	 * Constructor
	 * 
	 * @param dataSource Datasource for connection
	 */
	public UserDataService(DataSource dataSource) {
		this.datasource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public UserModel findByUsername(UserModel username) {
		// SQL statement used to pull data from the database
		String sql = "SELECT * FROM Users WHERE USERNAME = '" + username.getUsername() + "'";
		try {
			// Creating the SQL query to pull from the database
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			// If the database returned a user
			if (srs.next()) {
				// Putting the data from the database into a UserModel
				UserModel foundUser = new UserModel(srs.getString("FIRSTNAME"), srs.getString("LASTNAME"),
						srs.getString("EMAIL"), srs.getString("ADDRESS"), srs.getLong("PHONENUMBER"),
						srs.getString("USERNAME"), srs.getString("PASSWORD"));
				// Returning the user
				return foundUser;
			}
		} catch (Exception e) {
			// If the sql statement had a problem
			System.out.println("ERROR IN THE SQL, " + sql);
		}
		return null;
	}

	@Override
	public UserModel createUser(UserModel newUser) {
		// SQL statement to add a user into the database
		String sql = "INSERT INTO Users(`FIRSTNAME`, `LASTNAME`, `EMAIL`, `ADDRESS`, `PHONENUMBER`, `USERNAME`, `PASSWORD`)VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			// Execute SQL insert
			int rows = jdbcTemplateObject.update(sql, newUser.getFirstName(), newUser.getLastName(), newUser.getEmail(),
					newUser.getAddress(), newUser.getPhoneNumber(), newUser.getUsername(), newUser.getPassword());

			// If no rows were affected then it will print this statement
			if (rows == 0) {
				System.out.println("ERROR: USER NOT CREATED");
				return null;
			}

			// Return the results of the insert
			return findByUsername(newUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean login(UserModel user) {
		// SQL statement used to check the users in the database
		String sql = "SELECT * FROM Users WHERE USERNAME = '" + user.getUsername() + "' AND PASSWORD = '"
				+ user.getPassword() + "'";
		try {
			// Creating and executing the sql query
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			// If a user is returned from the database return true
			if (srs.next()) {
				return true;
			}
		} catch (Exception e) {
			// If there was a problem in the SQL this will throw
			System.out.println("ERROR IN THE SQL, " + sql);
		}
		return false;
	}

	@Override
	public boolean isAdmin(UserModel user) {
		// SQL statement to find if the user is an admin
		String sql = "SELECT * FROM Users WHERE USERNAME = '" + user.getUsername() + "' AND ROLE = 'Admin'";
		try {
			// Creating and executing the sql query
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			// If the database returns a user, then the user is an admin
			if (srs.next()) {
				return true;
			}
		} catch (Exception e) {
			// If there was a problem with the SQL this throws
			System.out.println("ERROR IN THE SQL, " + sql);
		}
		return false;
	}

	@Override
	public String getUsersRole(UserModel user) {
		// SQL statement used to pull data from the database
		String sql = "SELECT * FROM Users WHERE USERNAME = '" + user.getUsername() + "'";
		try {
			// Creating the SQL query to pull from the database
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			// If the database returned a user
			if (srs.next()) {
				String role = srs.getString("ROLE");
				
				return role;
			}
		} catch (Exception e) {
			// If the sql statement had a problem
			System.out.println("ERROR IN THE SQL, " + sql);
		}
		return null;
	}

}

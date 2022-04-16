package com.azsnowsports.data;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.azsnowsports.model.PostModel;

/**
 * @author Zac Almas and Austin Driver
 *
 * Data service used for blog data access
 */
@SuppressWarnings({"unused"})
@Service
public class BlogDataService implements BlogDataAccessInterface<PostModel> {
	/**
	 * Datasource for connecting to the database
	 */
	@Autowired
	private DataSource datasource;
	/**
	 * JDBC object used for executing sql statements 
	 */
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Constructor
	 * @param dataSource Datasource for our connection
	 */
	public BlogDataService(DataSource dataSource)
	{
		this.datasource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void createBlog(PostModel post) {
		//SQL statement used to get data from the database
		String sql = "INSERT INTO Posts(TITLE, BODY, Author) VALUES (?, ?, ?)";
		try
		{
			//Execute SQL insert 
			int rows = jdbcTemplateObject.update(sql, post.getTitle(), post.getBody(), post.getUserid());
			
			//If no rows were effected then it will print this statement
			if (rows == 0)
			{
				System.out.println("ERROR: USER NOT CREATED");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public PostModel findBlogById(PostModel postId) {
		//SQL statement used to get the blog from the database
		String sql = "SELECT * FROM `Posts` WHERE ID = " + postId.getId();
		try
		{
			//Execute sql Query and loop over results
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			if (srs.next())
			{
				//Adding post from the database and returning
				PostModel post = new PostModel(srs.getLong("ID"), srs.getString("TITLE"), srs.getString("BODY"), srs.getString("AUTHOR"));
				return post;
			}
		}catch (Exception e)
		{
			//There's a problem
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean deleteBlog(PostModel post) {
		//SQL statement used to delete data from the database
		String sql = "DELETE FROM `Posts` WHERE ID = ?";
		try
		{
			//Execute sql query
			int rows = jdbcTemplateObject.update(sql, post.getId());
			if (rows != 0)
			{
				//If the rows affected are higher than 1 that means a post was deleted so return true
				return true;
			} else {
				//If the rows affected are 0 then nothing happened so nothing was deleted and return false
				return false;
			}
		} catch (Exception e)
		{
			//Something went wrong
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateBlog(PostModel post) {
		//SQL statement to update blogs in the database
		String sql = "UPDATE `Posts` SET TITLE = ?, BODY = ? WHERE ID = ?";
		try
		{
			//Update and execute the sql query
			int rows = jdbcTemplateObject.update(sql, post.getTitle(), post.getBody(), post.getId());
			//If there were any rows affected then it will return true
			if (rows != 0)
			{
				return true;
			} else {
				return false;
			}
		}catch (Exception e)
		{
			//Something went wrong
			e.printStackTrace();
		}
		
		return false;
	}

}

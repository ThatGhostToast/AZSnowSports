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
 * @author Zac Almas & Austin Driver
 *
 * Data service used for blog data access
 */
@SuppressWarnings({"unused"})
@Service
public class BlogDataService implements BlogDataAccessInterface<PostModel> {
	@Autowired
	private DataSource datasource;
	private JdbcTemplate jdbcTemplateObject;
	
	//Constructor
	public BlogDataService(DataSource dataSource)
	{
		this.datasource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<PostModel> getAllBlogs() {
		//SQL statement used to get the posts from the database
		String sql = "SELECT * FROM Posts";
		//List to hold the posts from the database
		List<PostModel> posts = new ArrayList<PostModel>();
		try
		{
			//Execute sql Query and loop over results
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while (srs.next())
			{
				posts.add(new PostModel(srs.getLong("ID"), srs.getString("TITLE"), srs.getString("BODY"), srs.getString("AUTHOR")));
			}
			return posts;
		}catch (Exception e)
		{
			//If there's a problem
			e.printStackTrace();
		}
		return null;
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

}

package com.azsnowsports.data;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.azsnowsports.model.PostModel;

@SuppressWarnings({"unused"})
@Service
public class BlogDataService implements BlogDataAccessInterface<PostModel> {
	@Autowired
	private DataSource datasource;
	private JdbcTemplate jdbcTemplateObject;
	
	public BlogDataService(DataSource dataSource)
	{
		this.datasource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<PostModel> getAllBlogs() {
		String sql = "SELECT * FROM Posts";
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
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createBlog(PostModel post) {
		String sql = "INSERT INTO Posts(TITLE, BODY, Author) VALUES (?, ?, ?)";
		try
		{
			//Execute SQL insert 
			int rows = jdbcTemplateObject.update(sql, post.getTitle(), post.getBody(), post.getUserid());
			
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

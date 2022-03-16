package com.azsnowsports.data;

import java.util.List;

/**
 * @author Zac Almas & Austin Driver
 *
 * Interface used for the blog data access
 */
public interface BlogDataAccessInterface<T> {
	/**
	 * Method used to get all the blogs in the database
	 * @return returns the blogs
	 */
	public List<T> getAllBlogs();
	/**
	 * Method used to create a blog in the database
	 * @param post Post being created
	 */
	public void createBlog(T post);
	
}

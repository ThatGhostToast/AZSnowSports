package com.azsnowsports.data;

import java.util.List;

import com.azsnowsports.model.PostModel;

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
	/**
	 * Method used to get a blog post by its id
	 * @param postId Id of the blog we're looking for
	 * @return Returns the blog
	 */
	public PostModel findBlogById(T postId);
	/**
	 * Method used for updating blog posts
	 * @param post Post being updated 
	 * @return Returns if the update was successful
	 */
	public boolean updateBlog(T post);
	/**
	 * Method used to delete a blog from the database
	 * @param post Post that's being deleted
	 * @return returns if the delete happened
	 */
	public boolean deleteBlog(T post);
	
}

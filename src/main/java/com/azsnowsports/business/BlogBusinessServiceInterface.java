package com.azsnowsports.business;

import java.util.List;

import com.azsnowsports.model.PostModel;

/**
 * @author Zac Almas & Austin Driver
 *
 * Interface used for the blog business service
 */
public interface BlogBusinessServiceInterface 
{
	/**
	 * Method used to get the blog in the model
	 * @return Returns this.blog
	 */
	public PostModel getBlog();
	/**
	 * Method used to save a blog post in the model
	 * @param post Post to be saved 
	 */
	public void saveBlog(PostModel post);
	/**
	 * Method used to get all blogs from the database
	 * @return Returns a list of all blogs
	 */
	public List<PostModel> getAllBlogs();
	/**
	 * Method used to add a blog into the database
	 * @param post Post being added to the database
	 */
	public void createBlog(PostModel post);

}

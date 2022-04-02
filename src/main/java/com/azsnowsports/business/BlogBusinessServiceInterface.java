package com.azsnowsports.business;

import java.util.List;

import com.azsnowsports.model.PostModel;

/**
 * @author Zac Almas and Austin Driver
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
	/**
	 * Method used to find a post by its id
	 * @param postId Id of the post being searched
	 * @return returns the post
	 */
	public PostModel findById(PostModel postId);
	/**
	 * Method used for updating blog posts in the database
	 * @param post Post being updated
	 * @return Returns if the blog was updated
	 */
	public boolean updatePost(PostModel post);
	/**
	 * Method used to delete a post
	 * @param post Post to delete
	 * @return Returns if the post was deleted
	 */
	public boolean deletePost(PostModel post);

}

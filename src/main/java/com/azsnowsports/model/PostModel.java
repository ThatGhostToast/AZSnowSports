package com.azsnowsports.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Zac Almas and Austin Driver
 *
 * Model used for posts
 */
public class PostModel {
	/**
	 * Title of the blog post
	 */
	@NotBlank(message="Title is a required field.")
	private String title;
	/**
	 * Content of the blog post
	 */
	@NotNull(message="Body is a required field.")
	private String body;
	/**
	 * Id of the blog post
	 */
	private long id;
	/**
	 * Id of the user who posted the blog
	 */
	private String userid;
	
	/**
	 * Constructor used to add a blog post (Doesn't require ID)
	 * @param titleVal Title of the blog
	 * @param bodyVal Content of the blog
	 * @param userId Id of the user making the post
	 */
	public PostModel(String titleVal, String bodyVal, String userId)
	{
		this.title = titleVal;
		this.body = bodyVal;
		this.userid = userId;
	}
	
	/**
	 * Constructor used to pull a blog from the database (Requires ID)
	 * @param id Id of the blog post
	 * @param titleVal Title of the blog 
	 * @param bodyVal Content of the blog
	 * @param user Id of the user that posted the blog
	 */
	public PostModel(long id, String titleVal, String bodyVal, String user)
	{
		this.id = id;
		this.title = titleVal;
		this.body = bodyVal;
		this.userid = user;
	}
	
	/**
	 * Constructor used by the rest service. It takes in an id and nothing else
	 * @param id Id of the blog
	 */
	public PostModel(String id)
	{
		this.id = Long.parseLong(id);
		this.title = "";
		this.body = "";
		this.userid = "";
	}
	
	/**
	 * Default constructor
	 */
	public PostModel()
	{
		this.title = "";
		this.body = "";
	}
	

	/**
	 * Constructor used for finding a post by id
	 * @param id Id of the blog post we're searching
	 */
	public PostModel(long id)
	{
		this.id = id;
		this.title = "";
		this.body = "";
		this.userid = "";
	}
	
	/**
	 * Method used to get the title of the blog
	 * @return Returns the title
	 */
	public String getTitle()
	{
		return this.title;
	}
	
	/**
	 * Method used to set the title of the blog
	 * @param newTitle New title to be entered
	 */
	public void setTitle(String newTitle)
	{
		this.title = newTitle;
	}
	
	/**
	 * Method used to get the body of the blog
	 * @return Returns the body
	 */
	public String getBody()
	{
		return this.body;
	}
	
	/**
	 * Method used to set the body of the blog
	 * @param newBody New body to be entered
	 */
	public void setBody(String newBody)
	{
		this.body = newBody;
	}
	
	/**
	 * Method used to get the Id of the blog post
	 * @return Returns the blog id
	 */
	public long getId()
	{
		return this.id;
	}
	
	/**
	 * Method used to set the id of the blog post
	 * @param newId New Id of the blog post
	 */
	public void setId(long newId)
	{
		this.id = newId;
	}
	
	/**
	 * Method used to get the user who posted the blog
	 * @return returns the id of the user
	 */
	public String getUserid()
	{
		return this.userid;
	}
	
	/**
	 * Method used to set the user who posted the blog
	 * @param id Id of the user who posted
	 */
	public void setUserid(String id)
	{
		this.userid = id;
	}
	
}

package com.azsnowsports.model;

import javax.validation.constraints.NotNull;

public class PostModel {
	@NotNull(message="Title is a required field.")
	private String title = "";
	@NotNull(message="Body is a required field.")
	private String body = "";
	
	public PostModel(String titleVal, String bodyVal)
	{
		this.title = titleVal;
		this.body = bodyVal;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public void setTitle(String newTitle)
	{
		this.title = newTitle;
	}
	
	public String getBody()
	{
		return this.body;
	}
	
	public void setBody(String newBody)
	{
		this.body = newBody;
	}
	
}

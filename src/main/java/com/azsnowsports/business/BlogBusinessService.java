package com.azsnowsports.business;

import com.azsnowsports.model.PostModel;

public class BlogBusinessService implements BlogBusinessServiceInterface
{
	private PostModel blog = new PostModel("First Blog", "Blog Content");

	public PostModel getBlog()
	{
		return blog;
	}
}

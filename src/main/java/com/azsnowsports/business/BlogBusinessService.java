package com.azsnowsports.business;

import com.azsnowsports.model.PostModel;

public class BlogBusinessService implements BlogBusinessServiceInterface
{
	private PostModel blog;

	public PostModel getBlog()
	{
		return blog;
	}

	@Override
	public void saveBlog(PostModel post) {
		blog = post;
	}
}

package com.azsnowsports.business;

import com.azsnowsports.model.PostModel;

public interface BlogBusinessServiceInterface 
{
	public PostModel getBlog();
	public void saveBlog(PostModel post);

}

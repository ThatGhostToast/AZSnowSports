package com.azsnowsports.business;

import java.util.List;

import com.azsnowsports.model.PostModel;

public interface BlogBusinessServiceInterface 
{
	public PostModel getBlog();
	public void saveBlog(PostModel post);
	public List<PostModel> getAllBlogs();
	public void createBlog(PostModel post);

}

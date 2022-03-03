package com.azsnowsports.data;

import java.util.List;

public interface BlogDataAccessInterface<T> {
	public List<T> getAllBlogs();
	public void createBlog(T post);
	
}

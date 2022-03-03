package com.azsnowsports.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.azsnowsports.data.BlogDataAccessInterface;
import com.azsnowsports.model.PostModel;

@SuppressWarnings({"unchecked", "rawtypes"})
public class BlogBusinessService implements BlogBusinessServiceInterface
{
	private PostModel blog;
	private List<PostModel> totalPosts;
	
	@Autowired
	private BlogDataAccessInterface access;

	public PostModel getBlog()
	{
		return blog;
	}

	@Override
	public void saveBlog(PostModel post) {
		blog = post;
	}

	@Override
	public List<PostModel> getAllBlogs() {
		totalPosts = access.getAllBlogs();
		return totalPosts;
	}

	@Override
	public void createBlog(PostModel post) {
		access.createBlog(post);	
	}
	
}

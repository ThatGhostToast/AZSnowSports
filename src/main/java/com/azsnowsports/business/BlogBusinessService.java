package com.azsnowsports.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.azsnowsports.data.BlogDataAccessInterface;
import com.azsnowsports.model.PostModel;

/**
 * @author Zac Almas & Austin Driver
 *
 * Business service used for the blog posts
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class BlogBusinessService implements BlogBusinessServiceInterface
{
	/**
	 * Current blog
	 */
	private PostModel blog;
	/**
	 * List of all blogs
	 */
	private List<PostModel> totalPosts;
	
	/**
	 * Private attribute used to access our data access interface
	 */
	@Autowired
	private BlogDataAccessInterface access;

	public PostModel getBlog()
	{
		//Returns the current blog
		return blog;
	}

	@Override
	public void saveBlog(PostModel post) {
		//Saves the current blog
		blog = post;
	}

	@Override
	public List<PostModel> getAllBlogs() {
		//Calling the data access layer to get all blogs from the database
		totalPosts = access.getAllBlogs();
		return totalPosts;
	}

	@Override
	public void createBlog(PostModel post) {
		//Calling the data access layer to add a blog into the database
		access.createBlog(post);	
	}

	@Override
	public PostModel findById(PostModel postId) {
		//Getting the post from the database
		PostModel post = access.findBlogById(postId);
		return post;
	}

	@Override
	public boolean deletePost(PostModel post) {
		//If the blog was deleted it will return true
		return access.deleteBlog(post);
	}

	@Override
	public boolean updatePost(PostModel post) {
		//If the blog was updated it will return true
		return access.updateBlog(post);
	}
	
}

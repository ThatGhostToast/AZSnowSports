package com.azsnowsports.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.azsnowsports.data.BlogDataAccessInterface;
import com.azsnowsports.model.PostModel;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

/**
 * @author Zac Almas and Austin Driver
 *
 * Business service used for the blog posts
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class BlogBusinessService implements BlogBusinessServiceInterface
{
	/**
	 * Private class variable for the eureka client
	 */
	@Autowired
	private EurekaClient eurekaClient;
	
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
		//Getting the eureka client API
		Application application = eurekaClient.getApplication("blog-service");
		//Getting the instance of the application
		InstanceInfo instanceInfo = application.getInstances().get(0);
		//Setting the host name of the API
		String hostname = instanceInfo.getHostName();
		//Setting the Port of the API
		int port = instanceInfo.getPort();
		
		//Constructing the url from our host name and port
		String url = "http://" + hostname + ":" + port + "/service/blogs";
		//Initializing a new rest template
		RestTemplate restTemplate = new RestTemplate();
		//Getting the response from the API
		ResponseEntity<List<PostModel>> rateResponse = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<PostModel>>() {});
		//Populating total posts with the API response
		totalPosts = rateResponse.getBody();
		
		//Returning the posts
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

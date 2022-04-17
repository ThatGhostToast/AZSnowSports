package com.azsnowsports.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.azsnowsports.business.BlogBusinessService;
import com.azsnowsports.model.PostModel;

@RestController
@RequestMapping("/service")
public class BlogRestService {
	
	@Autowired
	BlogBusinessService service;
	
	@GetMapping(path="/blogs")
	public ResponseEntity<?> getBlogs()
	{
		try
		{
			List<PostModel> orders = service.getAllBlogs();
			if (orders == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(orders, HttpStatus.OK);
		}catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path="/createBlog")
	public ResponseEntity<?> createBlog(@RequestParam(value="blog") PostModel newPost)
	{
		if (newPost == null)
		{
			System.out.println("ERROR: NEW POST PARAMETER NOT PASSED TO API");
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} else {
			try
			{
				service.createBlog(newPost);
				System.out.println("SUCCESS: POST ADDED TO DATABASE");
				return new ResponseEntity<>(true, HttpStatus.OK);
			} catch (Exception e)
			{
				e.printStackTrace();
				System.out.println("ERROR: INTERNAL SYSTEM ERROR");
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
}

package com.azsnowsports.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azsnowsports.model.BlogList;
import com.azsnowsports.model.PostModel;

/**
 * @author Zac Almas and Austin Driver
 *
 * Interface used for the blog business service
 */
@RestController
@RequestMapping("/service")
public class BlogRestService {
	/**
	 * Interface service connection to use methods
	 */
	@Autowired
	private BlogBusinessServiceInterface service;

	/**
	 * Method used for getting the blog as JSON
	 * 
	 * @return Returns the blogs in JSON format
	 */
	@GetMapping(path = "/getJson", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<PostModel> getBlogsAsJson() {
		// Returns all the blogs
		return service.getAllBlogs();
	}

	/**
	 * Method used for getting the blog as XML
	 * 
	 * @return Returns the data in XML format
	 */
	@GetMapping(path = "/getxml", produces = { MediaType.APPLICATION_XML_VALUE })
	public BlogList getBlogsAsXml() {
		// New blog list to hold the blogs
		BlogList list = new BlogList();
		// Getting the blogs from the database
		list.setOrders(service.getAllBlogs());
		// Returning the list of blogs
		return list;
	}

	/**
	 * Method used to get a specific blog by its ID
	 * 
	 * @param id ID of the blog being searched
	 * @return Returns the blog if found
	 */
	@GetMapping(path = "/getblog/{id}")
	public ResponseEntity<?> getBlog(@PathVariable("id") String id) {
		// Try catch block for catching internal errors
		try {
			// Getting the post by its ID
			PostModel post = service.findById(new PostModel(id));
			// If the post is null that means the post was not found
			if (post == null) {
				// Prompt the user with what went wrong
				return new ResponseEntity<>("Post with ID of " + id + " could not be found.", HttpStatus.NOT_FOUND);
			} else {
				// If the post was found display the post
				return new ResponseEntity<>(post, HttpStatus.OK);
			}
		} catch (Exception e) {
			// If there's something wrong with the program itself this will throw
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

package com.azsnowsports.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.azsnowsports.business.BlogBusinessServiceInterface;
import com.azsnowsports.business.UserBusinessServiceInterface;
import com.azsnowsports.data.UserDataService;
import com.azsnowsports.model.PostModel;
import com.azsnowsports.model.UserModel;

/**
 * @author Zac Almas and Austin Driver
 * 
 *	Controller is used for creating a blog.
 */
@Controller
@RequestMapping("/createBlog")
public class BlogController {
	/**
	 * Private autowired attribute to access the blog business service
	 */
	@Autowired
	private BlogBusinessServiceInterface service;
	/**
	 * Private autowired attribute to access the user business service
	 */
	@Autowired
	private UserBusinessServiceInterface userService;

	/**
	 * Method used for displaying the blog form
	 * 
	 * @param model Thymeleaf model
	 * @return Returns the form to create a blog
	 */
	@GetMapping("/")
	public ModelAndView display(Model model) {
		//Model and View used to help our blog display
		ModelAndView mav = new ModelAndView("createBlog");
		//Adds the user as an object
		mav.addObject("user", userService.getUserByUsername(new UserModel(UserDataService.currentUserUsername)));
		//Adds a post object we can use
		mav.addObject("post", new PostModel());
		return mav;
	}
	
	/**
	 * Method used for creating a blog post that saves to the database
	 * 
	 * @param postModel Post being created
	 * @param br The binding result
	 * @param model Thymeleaf model
	 * @return Returns either the success page or returns them to their post if there is an error
	 */
	@PostMapping("/doBlogPost")
	public String doBlogPost(@Valid PostModel postModel, BindingResult br, Model model) {
		// Check for validation errors
		if (br.hasErrors()) {
			model.addAttribute("blog", "Timeline Form");
			return "createBlog";
		}
		else
		{
			//returning the new blogpost as a view
			service.createBlog(postModel);
			//Saving the blog post
			service.saveBlog(postModel);
			//Setting the blog as an object
			model.addAttribute("blog", service.getBlog());
			//Returning the success screen
			return "blogpostSuccess";
		}
	}
}

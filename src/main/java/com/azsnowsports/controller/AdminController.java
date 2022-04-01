package com.azsnowsports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.azsnowsports.business.BlogBusinessServiceInterface;
import com.azsnowsports.model.PostModel;

/**
 * @author Zac Almas & Austin Driver
 * 
 *	Controller is used for the admin page
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	/**
	 * Private autowired attribute to access the blog business service
	 */
	@Autowired
	private BlogBusinessServiceInterface service;
	
	@GetMapping("/")
	public ModelAndView display(Model model)
	{
		//Model and view to return the blogs
		ModelAndView mav = new ModelAndView("admin");
		
		//Adding the blogs
		mav.addObject("blogs", service.getAllBlogs());
		
		//Returning the mav
		return mav;
	}
	
	@RequestMapping("/function/edit/{id}")
	public String editBlog(@PathVariable("id") long id, Model model)
	{
		//Getting the post model from the database and setting it as a model attribute
		PostModel pm = new PostModel(id);
		//Adding in the attributes
		model.addAttribute("blog", service.findById(pm));
		model.addAttribute("post", new PostModel());
		
		return "function/edit";
	}
	
	@RequestMapping("/function/doEdit/{id}")
	public String doEdit(@PathVariable("id") long id, Model model, PostModel post)
	{
		//Setting the post id to the id of the blog being updated
		post.setId(id);
		
		//If the post was updated it will go to the success page
		if (service.updatePost(post))
		{
			return "function/editSuccess";		
		}
		//If the post was not updated then it will redirect to the failed page
		return "function/editFailed";
	}
	
	@RequestMapping("/function/delete/{id}")
	public String deleteBlog(@PathVariable("id") long id, Model model)
	{
		//Getting the post model from the database and setting it as a model attribute
		PostModel pm = new PostModel(id);
		model.addAttribute("blog", service.findById(pm));
		
		//Redirecting to the delete function page
		return "function/delete";
	}
	
	@RequestMapping("/function/doDelete/{id}")
	public String doDelete(@PathVariable("id") long id, Model model)
	{
		//Getting the post model from the database to delete it
		PostModel pm = new PostModel(id);
		pm = service.findById(pm);
		//Deleting the post
		if (service.deletePost(pm))
		{
			//If the post was successfully deleted then it will redirect the user to the success page
			return "function/deleteSuccess";	
		} else {
			//If the post was not deleted it will show the delete failed page
			return "function/deleteFail";
		}
	}
}

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
import com.azsnowsports.model.PostModel;

/**
 * @author Zac Almas & Austin Driver
 * 
 *	Controller is used for creating a blog.
 */
@Controller
@RequestMapping("/createBlog")
public class BlogController {
	@Autowired
	private BlogBusinessServiceInterface service;
	@Autowired
	private UserBusinessServiceInterface userService;

	@GetMapping("/")
	public ModelAndView display(Model model) {
		ModelAndView mav = new ModelAndView("createBlog");
		mav.addObject("user", userService.getUser());
		mav.addObject("post", new PostModel());
		return mav;
	}
	
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
			service.saveBlog(postModel);
			model.addAttribute("blog", service.getBlog());
			return "blogpostSuccess";
		}
	}
}

package com.azsnowsports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.azsnowsports.business.BlogBusinessService;
import com.azsnowsports.model.UserModel;

/**
 * @author Zac Almas & Austin Driver
 * 
 *	Controller is used for the timeline of the application.
 */
@Controller
@RequestMapping("/timeline")
public class TimelineController {
	
	@Autowired
	private BlogBusinessService service;

	@GetMapping("/")
	public ModelAndView display(UserModel usrModel, Model model) {
		ModelAndView mav = new ModelAndView("timeline");
		mav.addObject("user", usrModel);
		mav.addObject("blog", service.getAllBlogs());
		return mav;
	}
}

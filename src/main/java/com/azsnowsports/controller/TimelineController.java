package com.azsnowsports.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.azsnowsports.business.BlogBusinessServiceInterface;
import com.azsnowsports.model.PostModel;
import com.azsnowsports.model.UserModel;

@Controller
@RequestMapping("/timeline")
public class TimelineController {
	
	@Autowired
	private BlogBusinessServiceInterface service;
	
	@GetMapping("/")
	public ModelAndView display(UserModel usrModel)
	{
		ModelAndView mav = new ModelAndView("timeline");
		mav.addObject("user", usrModel);
		return mav;
	}
	
	@PostMapping("/doBlogPost")
	public String doBlogPost( Model model)
	{
		model.addAttribute("blog", service.getBlog());
		return "blogpost";
	}
}

package com.azsnowsports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.azsnowsports.model.UserModel;

@Controller
@RequestMapping("/timeline")
public class TimelineController {
	
	@GetMapping("/")
	public ModelAndView display(UserModel usrModel)
	{
		ModelAndView mav = new ModelAndView("timeline");
		mav.addObject("user", usrModel);
		return mav;
	}
}

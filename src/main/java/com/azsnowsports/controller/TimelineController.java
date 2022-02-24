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
import com.azsnowsports.model.PostModel;
import com.azsnowsports.model.UserModel;

@Controller
@RequestMapping("/timeline")
public class TimelineController {

	@Autowired
	private BlogBusinessServiceInterface service;

	@GetMapping("/")
	public ModelAndView display(UserModel usrModel) {
		ModelAndView mav = new ModelAndView("timeline");
		mav.addObject("user", usrModel);
		mav.addObject("post", new PostModel());
		return mav;
	}

	@PostMapping("/doBlogPost")
	public String doBlogPost(@Valid PostModel postModel, BindingResult br, Model model) {

		// Check for validation errors
		if (br.hasErrors()) {
			model.addAttribute("blog", "Timeline Form");
			return "timeline";
		}
		else
		{
			// model.addAttribute("postModel", new PostModel());
			model.addAttribute("blog", service.getBlog());
			return "blogpost";
		}
	}
}

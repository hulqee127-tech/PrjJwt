package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MainController {

	@GetMapping("/")
	public String mainP() {
		
		return "<h1>main Controller</h1>";
	}
}

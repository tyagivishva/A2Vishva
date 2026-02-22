// Student ID: 991811327 | Name: Vishva Tyagi
package com.A2Vishva.A2Vishva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("studentName", "Vishva Tyagi");
		model.addAttribute("studentId", "991811327");
		model.addAttribute("welcomeMessage", "Welcome to the Movie Database Application!");
		return "index";
	}
}

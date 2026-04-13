package com.e_commerce.project.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class ForUser {
@GetMapping("/homepage")	
public String home() {
	
	
	return "USER/userhome";
			}

@GetMapping("/view-details")	
public String view_Details() {
	
	
	return "USER/view_Detail_page";
			}
}

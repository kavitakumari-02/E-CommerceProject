package com.e_commerce.project.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.e_commerce.project.printing.Message;

import jakarta.validation.Valid;

@Controller
public class Registration {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	 @GetMapping("/login")
	  	public String login() {
	  	   
	  		return"REGISTRATION/login";
	  	}
	 
   @GetMapping("/register")
	public String registrationpage(Model model) {
	   model.addAttribute("user", new User());
		return"REGISTRATION/register";
	}
   @PostMapping("/registerHandlerPage")
	public String registerHandler(@Valid @ModelAttribute("user")User user,BindingResult result,Model model,RedirectAttributes redirectAttributes) {
	   if(result.hasErrors()) {
		   model.addAttribute("user", user);
		   
		   return "REGISTRATION/register";
	   }
	   else {
		 user.setPassword(passwordEncoder.encode(user.getPassword()));
		 user.setConfirmPassword(passwordEncoder.encode(user.getConfirmPassword()));
		   user.setRole("ROLE_USER");
		userRepository.save(user);
		
		 redirectAttributes.addFlashAttribute("message", new Message("Data Entery succesfull","success"));
	   }
		return "redirect:/register";
	}
   
  
}

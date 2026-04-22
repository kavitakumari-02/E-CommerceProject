package com.e_commerce.project.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.e_commerce.project.category.model.Product;
import com.e_commerce.project.items.additems.AddItems;
import com.e_commerce.project.items.service.AddPServiceImp;

@Controller
@RequestMapping("/user")
public class ForUser {
	@Autowired
private AddPServiceImp addPServiceImp;	

	
@GetMapping("/homepage")	
public String home(Model model) {
	model.addAttribute("addProduct", new AddItems());
	List<Product>categories = addPServiceImp.getAllCategory();
	List<AddItems> allAddItems = addPServiceImp.findAllAddItems();
	model.addAttribute("allAddItems",allAddItems);
	model.addAttribute("category", categories);	
	
	return "USER/userhome";
			}

@GetMapping("/view-details/{id}")	
public String view_Details(@PathVariable("id")int id,Model model) {
	AddItems product = addPServiceImp.findItemsById(id).orElse(null);
	model.addAttribute("product", product);
	
	return "USER/view_Detail_page";
			}

}

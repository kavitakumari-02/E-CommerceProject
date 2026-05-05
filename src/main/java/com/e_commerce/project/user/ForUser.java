package com.e_commerce.project.user;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.e_commerce.project.category.model.Product;
import com.e_commerce.project.category.service.ServiceHandlerImp;
import com.e_commerce.project.items.additems.AddItems;
import com.e_commerce.project.items.service.AddPServiceImp;
import com.e_commerce.project.registration.User;
import com.e_commerce.project.registration.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class ForUser {

    private final ServiceHandlerImp serviceHandlerImp;
	@Autowired
private AddPServiceImp addPServiceImp;	

	@Autowired
	private UserRepository userRepository;


    ForUser(ServiceHandlerImp serviceHandlerImp) {
        this.serviceHandlerImp = serviceHandlerImp;
    }
		
	
@GetMapping("/homepage")	
public String home(Model model,Principal principal) {
	model.addAttribute("addProduct", new AddItems());
	String email = principal.getName();
	User user = userRepository.findByEmail(email);
	List<Product>categories = addPServiceImp.getAllCategory();
	List<AddItems> allAddItems = addPServiceImp.findAllAddItems();
	int cartCount = addPServiceImp.getCartCountByUserId(user.getId());
	model.addAttribute("allAddItems",allAddItems);
	model.addAttribute("category", categories);	
	model.addAttribute("cartCount", cartCount);
	
	return "USER/userhome";
			}

@GetMapping("/view-details/{id}")	
public String view_Details(@PathVariable("id")int id,Model model,Principal principal) {
	AddItems product = addPServiceImp.findItemsById(id).orElse(null);
	String email = principal.getName();
	User user = userRepository.findByEmail(email);
	int cartCount = addPServiceImp.getCartCountByUserId(user.getId());
	model.addAttribute("product", product);
	model.addAttribute("cartCount", cartCount);
	return "USER/view_Detail_page";
			}
@GetMapping("/add-cart/{id}")
public String addCarts(@PathVariable("id")int id,Principal principal) {
	
	String email = principal.getName();
User user = userRepository.findByEmail(email);
addPServiceImp.AddToCart(user.getId(), id);
	return "redirect:/view-details/"+id;
}
@GetMapping("/explore-category/{category}")
public String categoryExplore(@PathVariable("category")String category,Model model) {
	List<AddItems> categoryItems = addPServiceImp.findByCategory(category);
	List<Product> allCategory = addPServiceImp.getAllCategory();
	model.addAttribute("allCategory", allCategory);
	model.addAttribute("categoryItems", categoryItems);
	return "USER/categoryExplore";
}

}

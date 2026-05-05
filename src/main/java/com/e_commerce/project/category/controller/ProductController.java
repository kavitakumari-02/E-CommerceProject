
package com.e_commerce.project.category.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import javax.swing.text.Utilities;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.e_commerce.project.ECommerceProjectApplication;
import com.e_commerce.project.category.model.Product;
import com.e_commerce.project.category.repository.ProductRepository;
import com.e_commerce.project.category.service.ServiceHandlerImp;
import com.e_commerce.project.items.additems.AddItems;
import com.e_commerce.project.items.service.AddPServiceImp;

import jakarta.persistence.Id;

@Controller
@RequestMapping("/admin")
public class ProductController {

    private final ProductRepository productRepository;

    private final ECommerceProjectApplication ECommerceProjectApplication;
	@Autowired
	private ServiceHandlerImp serviceHandlerImp;
	@Autowired
    private AddPServiceImp addPServiceImp;
    ProductController(ECommerceProjectApplication ECommerceProjectApplication, ProductRepository productRepository) {
        this.ECommerceProjectApplication = ECommerceProjectApplication;
        this.productRepository = productRepository;
    }
	
    @GetMapping("/dashboard")
	public String adminDashboard() {
		
    	
    	return"ADMIN/adminDashBoard";
	}
    //ADD PRODUCT//
    @GetMapping("/add-product")
	public String addProduct(Model model) {
    	model.addAttribute("addProduct", new AddItems());
    	List<Product>categories = addPServiceImp.getAllCategory();

    	model.addAttribute("category", categories);
	return"ADMIN/addProduct";
	}
   
    @PostMapping("/product-add-handler")
    public String addProductHandler(  @RequestParam("productName") String productName,
            @RequestParam("price") double price,
            @RequestParam("category") String category,
            @RequestParam("quantity") int quantity,
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile file) throws IOException {
    	
    		
        // Create object manually
        AddItems aItems = new AddItems();

     if(file.isEmpty()) {
    	aItems.setImage("Default.png");	
    	}
     else {
        aItems.setProductName(productName);
        aItems.setPrice(price);
        aItems.setCategory(category);
        aItems.setQuantity(quantity);
        aItems.setDescription(description);
        
        String dirPath="C:\\Users\\hp\\Documents\\workspace-spring-tools-for-eclipse-5.0.1.RELEASE\\E-CommerceProject\\src\\main\\resources\\static\\image/";
		String filename = file.getOriginalFilename();
       Path path=Paths.get(dirPath+filename);
       Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        aItems.setImage(filename);
     }
      addPServiceImp.saveAddItems(aItems);
        return "redirect:/admin/add-product";
    }
    
    @GetMapping("/viewProduct")
    public String viewProductHandler(Model model) {
    	List<AddItems> allAddItems = addPServiceImp.findAllAddItems();
    	model.addAttribute("allAddItems",allAddItems);
    	return "ADMIN/ViewProducts";
    }
    
    @GetMapping("/add-category")
   	public String addcategory() {
	
   	return"ADMIN/addCategory";
   	} 
    @PostMapping("/add-category-handler")
    public String addCategoryHandler(@RequestParam("category") String category,
            @RequestParam("productName") String productName,
            @RequestParam("description") String description,
            @RequestParam("isActive") boolean isActive,
            @RequestParam("fileImage") MultipartFile file,Model model) throws IOException
    		 {
    	Product product = new Product();
    	
    	if(serviceHandlerImp.existsByCategory(category))
    	 {
    		List<Product> allCategorys = serviceHandlerImp.getByCategorys(category);
    		 List<Product> allProduct = serviceHandlerImp.findAllProduct();
    	
    		    model.addAttribute("allProduct", allProduct);
    		model.addAttribute("product", new Product());
    		model.addAttribute("allCategorys", allCategorys);
    		System.out.println(allCategorys);
    		return "ADMIN/addCategory";
    	}
    	else {
    	product.setCategory(category);
    	product.setProductName(productName);
    	product.setDescription(description);
    	product.setActive(isActive);
    if(file.isEmpty()) {
    	product.setFileImage("Default.png");
    }
   String dirPath="C:\\Users\\hp\\Documents\\workspace-spring-tools-for-eclipse-5.0.1.RELEASE\\E-CommerceProject\\src\\main\\resources\\static\\image/";
		String originalFilename = file.getOriginalFilename();
		Path path=Paths.get(dirPath+originalFilename);
		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
    	product.setFileImage(originalFilename);
   
    }
    Product product1 = serviceHandlerImp.addProduct(product);
    System.out.println(product1);
   
    	return"ADMIN/addCategory";	
    }
    @GetMapping("/add-category-handler")
    public String showCategory(Model model) {
    	List<Product> allProduct = serviceHandlerImp.findAllProduct();
    
        model.addAttribute("allProduct", allProduct);
        System.out.println(allProduct);
    	
    	return "ADMIN/addCategory";
    }
    
    @GetMapping("/update-category/{id}")
    public String editCategory(@PathVariable("id")int id,Model model) {
    	 Product product = serviceHandlerImp.EditProduct(id).orElse(null);
    	model.addAttribute("product", product);
    	return "ADMIN/updateCategory";
    }
    @PostMapping("/category-update-handler")
    public String editCategoryHandler(@ModelAttribute("product")Product product) {
    	serviceHandlerImp.addProduct(product); 
    	
    	return "redirect:/admin/add-category-handler";
    }
    @GetMapping("/delete-category/{id}")
    public String deleteCategory(@PathVariable("id")int id) {
    	boolean isDeleted=serviceHandlerImp.deleteProduct(id);
    	if(isDeleted) {
    	return "redirect:/admin/add-category-handler";
    	}
    	
    	
    	return "redirect:/admin/add-category-handler?error";
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

package com.e_commerce.project.items.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_commerce.project.category.model.Product;
import com.e_commerce.project.category.repository.ProductRepository;
import com.e_commerce.project.items.additems.AddItems;
import com.e_commerce.project.items.additems.Cart;
import com.e_commerce.project.items.repository.AddProductItemsRepository;
import com.e_commerce.project.items.repository.CartRepository;
import com.e_commerce.project.registration.User;
import com.e_commerce.project.registration.UserRepository;

@Service
public class AddPServiceImp implements AddPServiceHandler{
	@Autowired
   private ProductRepository productRepository;  
	@Autowired
private AddProductItemsRepository addProductItemsRepository;
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
		
	

    AddPServiceImp(AddProductItemsRepository addProductItemsRepository) {
        this.addProductItemsRepository = addProductItemsRepository;
    }
	@Override
	public AddItems saveAddItems(AddItems addItems) {
		
		return addProductItemsRepository.save(addItems);
	}
	
	public List<Product>getAllCategory(){
		
		return  productRepository.findAll();
		
	}
	@Override
	public List<AddItems>findAllAddItems() {
		return addProductItemsRepository.findAll();
		 
	}
	@Override
	public Optional<AddItems> findItemsById(int id) {
		
		 return addProductItemsRepository.findById(id);
		 
		
	}
	@Override
	public void AddToCart(int userId, int addItemsId) {
	AddItems addItems = addProductItemsRepository.findById(addItemsId).orElseThrow(()->new RuntimeException("Items not found"));
		User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("user not found exception"));
		 Optional<Cart> existInCart = cartRepository.findAddCartByUserAndAddItems(user, addItems);
		 if(existInCart.isPresent()) {
			Cart cart = existInCart.get(); 
			cart.setQuantity(cart.getQuantity()+1);
			cartRepository.save(cart);
			int quantity = cart.getQuantity();
		 }
		 else {
		 Cart cart=new Cart();
	    cart.setAddItems(addItems);
		cart.setUser(user);
		cart.setQuantity(1);
		cartRepository.save(cart);
		 }
	
	}
	@Override
	public int getCartCountByUserId(int userId) {
		User user = userRepository.findById(userId).get();
		List<Cart> cartItems = cartRepository.findByUser(user);
		int totalCount=0;
		for(Cart cart:cartItems ) {
			totalCount+=cart.getQuantity();
		}
		return totalCount;
		
	}
	@Override
	public List<AddItems> findByCategory(String category) {
		 return  addProductItemsRepository.findByCategory(category); 
		
	}
	
	

	

	
}

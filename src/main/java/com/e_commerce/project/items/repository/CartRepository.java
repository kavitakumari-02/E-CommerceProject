package com.e_commerce.project.items.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_commerce.project.items.additems.AddItems;
import com.e_commerce.project.items.additems.Cart;
import com.e_commerce.project.registration.User;

public interface CartRepository extends JpaRepository<Cart, Integer>{
Optional<Cart> findAddCartByUserAndAddItems(User user,AddItems addItems);
List<Cart>findByUser(User user);
}

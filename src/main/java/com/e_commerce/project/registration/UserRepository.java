package com.e_commerce.project.registration;

import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Integer> {
public User findByEmail(String email);
	

}

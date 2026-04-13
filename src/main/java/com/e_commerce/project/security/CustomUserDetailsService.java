package com.e_commerce.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.e_commerce.project.registration.User;
import com.e_commerce.project.registration.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
@Autowired	
UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	User user = userRepository.findByEmail(email);
	if(user==null) {
		throw new UsernameNotFoundException("User not present");
	}
		return new CustomUserDetail(user); 
			
		
	
	}
}

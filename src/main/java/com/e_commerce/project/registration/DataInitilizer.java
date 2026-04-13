package com.e_commerce.project.registration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitilizer implements CommandLineRunner{
private final UserRepository userRepository;
private final PasswordEncoder passwordEncoder;


	public DataInitilizer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
	this.userRepository = userRepository;
	this.passwordEncoder = passwordEncoder;
}
@Override
	public void run(String... args) throws Exception {
		
	if(userRepository.findByEmail("mom@12.com")!=null) {
		User admin=new User();
		admin.setName("Chander");
		admin.setEmail("mom@12");
		admin.setPhoneNumber("9876543678");
		admin.setPassword(passwordEncoder.encode("Mommi@12"));
		admin.setConfirmPassword(passwordEncoder.encode("Mommi@12"));
		admin.setRole("ROLE_ADMIN");
		userRepository.save(admin);
	}
	}

	
}

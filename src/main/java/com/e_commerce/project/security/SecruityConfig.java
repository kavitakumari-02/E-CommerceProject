package com.e_commerce.project.security;

import com.e_commerce.project.items.repository.AddProductItemsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecruityConfig {
    
	@Autowired
	private CustomSuccessHandler customSuccessHandler;

	private final CustomUserDetailsService userDetailsService;
	
	public SecruityConfig(CustomUserDetailsService userDetailsService) {
		this.userDetailsService=userDetailsService;
		
		
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
		
		http.authenticationProvider(authenticationProvider()) 
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/register","/registerHandlerPage","/login","/css/**").permitAll()
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/user/**").hasRole("USER").anyRequest().authenticated())
		
		        .formLogin(form -> form 
						.loginPage("/login")
						.loginProcessingUrl("/do_login")
						.usernameParameter("email")   
					    .passwordParameter("password")
						.successHandler(customSuccessHandler).permitAll())
		.logout(logout -> logout 
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout"));
		
		return http.build();
		
	}
	

}

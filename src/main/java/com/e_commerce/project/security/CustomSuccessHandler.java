package com.e_commerce.project.security;

import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		Collection<? extends GrantedAuthority>
		authorities=authentication.getAuthorities();
		
		for(GrantedAuthority auth : authorities) {
			if(auth.getAuthority().equals("ROLE_USER")) {
				response.sendRedirect("/user/homepage");
				return;
			}
			if(auth.getAuthority().equals("ROLE_ADMIN")) {
				response.sendRedirect("/admin/dashboard");
				return;
			}
		}
		response.sendRedirect("/login?logout");
	}

}

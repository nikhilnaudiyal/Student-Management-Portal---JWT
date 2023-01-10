package com.bct.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bct.app.configuration.CustomUserDetailService;
import com.bct.app.configuration.JwtAuthRequest;
import com.bct.app.configuration.JwtAuthResponse;
import com.bct.app.configuration.JwtTokenHelper;
import com.bct.app.dto.Role;
import com.bct.app.dto.User;

import com.bct.app.exceptions.ApiException;
import com.bct.app.repository.UserRepo;

import java.util.Set;

import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("/auth")
@CrossOrigin("http://localhost:8081")
public class AuthController {
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private CustomUserDetailService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepo userRepo;
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken( @RequestBody JwtAuthRequest request) throws Exception {
		
		System.out.println("request"+ request);
		this.authenticate(request.getUsername(), request.getPassword());
		
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
		
		String token = this.jwtTokenHelper.generateToken(userDetails);
		
		String username = this.jwtTokenHelper.getUsernameFromToken(token);
		
		User user = userRepo.findByUsername(username).get();
		String password = userDetails.getPassword();
		System.out.println(userDetails.getUsername());
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
		response.setUsername(username);
		response.setPassword(password);
		response.setUser(user);
		Set<Role> roleSet = user.getRole();
		
		//checking
		
		for (Role role : roleSet) {
			System.out.println(role.getName());
			response.setRole(role.getName());
					}
		
		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
	}

	private void authenticate(String username, String password) throws Exception {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		
		try
		{
		this.authenticationManager.authenticate(authenticationToken);
		}catch(BadCredentialsException e) {
			System.out.println("Invalid Details !!");
			throw new ApiException("Invalid username or password !!");
		}
	}

}

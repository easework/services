package com.ews.services.auth.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ews.services.auth.domain.ApplicationUser;
import com.ews.services.auth.repository.ApplicationUserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class JwtRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtRestController.class);
	
	@Autowired
	private ApplicationUserRepository applicationUserRepository;
	
	@RequestMapping(path={"/signin"}, method=RequestMethod.POST, consumes={"application/json"})
	public ResponseEntity<String> authenticate(@RequestBody ApplicationUser user) {
		
		ApplicationUser shadow = applicationUserRepository.findByUsername(user.getUsername());
		
		if(shadow == null) {
			return new ResponseEntity<String>("Username or Password is not Valid!", HttpStatus.UNAUTHORIZED);
		} else if(shadow.isCredentialsNonExpired() && shadow.isAccountNonExpired() && shadow.isAccountNonLocked() && shadow.isEnabled() && user.getPassword().trim().equalsIgnoreCase(shadow.getPassword())) {
			String jWtGenToken = Jwts.builder()
					.signWith(SignatureAlgorithm.HS256, "secret")
					.setHeaderParam("typ", "JWT")
					.setHeaderParam("alg", "HS256")
					.setSubject(shadow.getUsername())										
					.setExpiration(new Date(System.currentTimeMillis() + 30*60*1000))
					.compact();
			return new ResponseEntity<String>(jWtGenToken, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Username or Password is not Valid!", HttpStatus.UNAUTHORIZED);
	}
}



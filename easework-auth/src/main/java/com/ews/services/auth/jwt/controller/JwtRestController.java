package com.ews.services.auth.jwt.controller;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class JwtRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtRestController.class);
	
	@RequestMapping(path={"/signin"}, method=RequestMethod.POST)
	public ResponseEntity<String> authenticate(@RequestBody User user) {
				
		if(user.getUsername().trim().equalsIgnoreCase("user") && user.getPassword().trim().equalsIgnoreCase("pass")) {
			String jWtGenToken = Jwts.builder()
										.signWith(SignatureAlgorithm.HS256, "secret")
										.setHeaderParam("typ", "JWT")
										.setHeaderParam("alg", "HS256")
										.setSubject("LNJENACHK")
										.setExpiration(new Date(System.currentTimeMillis() + 30*60*1000))
										.compact();
			return new ResponseEntity<String>(jWtGenToken, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Username or Password is not Valid!", HttpStatus.UNAUTHORIZED);
	}
	
	
	private static final class User implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2467052939282223041L;
		String username;
		String password;
		
		public String getUsername() {
			return username;
		}
		public String getPassword() {
			return password;
		}
		
		@Override
		public String toString() {
			return "User [username=" + username + ", password=" + password + "]";
		}
	}
}



package com.dev.delta.accountt.controllers;

import java.security.Principal;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.delta.accountt.entities.UserAccountt;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserAccounttController {
	@RequestMapping("/login")
	public boolean login(@RequestBody UserAccountt user) {
		return user.getUsername().equals("admin") && user.getPassword().equals("admin");
	}

	@RequestMapping("/user")
	public Principal user(HttpServletRequest request) {
		String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
		return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
	}

}

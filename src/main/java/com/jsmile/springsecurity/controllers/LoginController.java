package com.jsmile.springsecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController
{
	@GetMapping( "/showLoginPage" )
	public String showLoginPage() 
	{
		System.out.println( "\n#### Show Login Page ####" );
		return "plain-login";
	}
	
	@GetMapping( "/access-denied" )
	public String showAccessDenied() 
	{
		System.out.println( "\n#### Show Access Denied Page ####" );
		return "access-denied";
	}	

}

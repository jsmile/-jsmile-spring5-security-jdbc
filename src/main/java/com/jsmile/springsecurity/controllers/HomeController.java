package com.jsmile.springsecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{
	@GetMapping( "/" )
	public String showHome() 
	{
		// after site connection
		return "landing-home";
	}
	
	@GetMapping( "/employees" )
	public String showEmployeeHome() 
	{
		// after success of login
		return "main-home";	
	}

	@GetMapping( "/leaders" )
	public String showManagerHome() 
	{
		// after success of login
		return "leaders";	
	}
	
	@GetMapping( "/systems" )
	public String showAdminHome() 
	{
		// after success of login
		return "systems";	
	}
	
}

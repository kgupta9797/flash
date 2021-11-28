package com.kishan.spring_boot.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
//adding comments
	@GetMapping("/delete_Admin")
	public String delete()
	{
		return "this is delete request only for Admin";
	}
	
	@GetMapping("/create_stud")
	public String create()
	{
		return "this create request only for student and Admin";
	}
	
}

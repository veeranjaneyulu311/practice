package com.example.firstproject.firstcontroller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstproject.firstdao.UserPojo;
import com.example.firstproject.firstservice.FirstService;



@RestController
public class FirstController {
    @Autowired
    FirstService firstService;
    
    @GetMapping("/dbtest")
    public List<Map<String,Object>> testDb(){
    	return firstService.testService();
    }
	
   
	@PostMapping("/register")
	public String registerUser(@RequestBody Register register) {
		return firstService.registerService(register);
	}
	
	
	
	@PostMapping("/login")
	public UserPojo loginUser(@RequestBody Login login) {
		return firstService.loginUserService(login);
	}
}

package com.tao.taodemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tao.taodemo.model.AppUser;
import com.tao.taodemo.service.UserService;

public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public int addUser(@RequestBody Map<String, String> parameter) throws Exception {
		String userName = parameter.get("userName");
		String role = parameter.get("role");
		String password = parameter.get("password");
		int num = userService.addUser(userName, role, password);
		return num;
	}
	
	@PostMapping("/user/createWithList")
	public int createWithUserList(@RequestBody List<Map<String, String>> parameterList) throws Exception {
		int result = 0;
		for (Map<String, String> param : parameterList) {
			result = result + userService.addUser(param.get("userName"), param.get("role"), param.get("password"));
		}
		return result;
	}
	
	@GetMapping("/user/login")
	public List<AppUser> login(@RequestBody Map<String, String> parameter) {
		List<AppUser> result = new ArrayList<>();
		String username = parameter.get("username");
		String password = parameter.get("password");
		try {
			result = userService.userLogin(username, password);
		} catch (Exception e) {
			
		}
		
		return result;
	}
	
	@GetMapping("/user/logout")
	public void logout() {
		
	}
	
	@GetMapping("/user/{username}")
    public void updateUser(@RequestBody Map<String, String> parameter, @PathVariable String userName) {
		String role = parameter.get("role");
		String password = parameter.get("password");
        try {
        	userService.updateUser(userName, role, password);
        } catch (Exception e) {
        	
        }
    }
	
}

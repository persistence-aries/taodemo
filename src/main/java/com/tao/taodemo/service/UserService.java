package com.tao.taodemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tao.taodemo.model.AppUser;
import com.tao.taodemo.repository.UserRepository;

@Service
public class UserService {
	   @Autowired
	   private UserRepository userRepository;

	    public List<AppUser> findAllUser() {
	        return userRepository.findAll();
	    }

	    public List<AppUser> findByName(String name) {
	        return userRepository.findByUserName(name);
	    }
	    
	    public int addUser(String userName, String role, String password) {
	        return userRepository.addUser(userName, role, password);
	    }
	    
	    public int updateUser(String userName, String role, String password) {
	    	return userRepository.updateUser(userName, role, password);
	    }
	    
	    public List<AppUser> userLogin(String userName, String password) {
	        return userRepository.findByUserNameAndPassword(userName, password);
	    }
}

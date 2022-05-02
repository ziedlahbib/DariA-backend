package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
  
	@Autowired
	UserService userservice;
	
	
	@GetMapping("/UserById/{id}")
    public User findUserById(@PathVariable long id) {
        return userservice.retrieveUser(id);
    }
	
	
}

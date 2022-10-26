package github.kimunche.dog.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import github.kimunche.dog.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/api/users")
	public Object listUsers() {
		// /api/users
		return userService.listUsers();
	}
}

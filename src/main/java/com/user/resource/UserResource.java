package com.user.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.bean.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
		Optional<User> user = userService.getUserByEmail(email);
		if(user.isPresent()) {
			return new ResponseEntity<User>(user.get(), HttpStatus.FOUND);
		}
		
		return new ResponseEntity<User>(new User(), HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User user) {
		if(!userService.getUserByEmail(user.getEmail()).isPresent()) {
			if(userService.addUser(user)) {
				return new ResponseEntity<User>(user, HttpStatus.CREATED);
			}
		}

		return new ResponseEntity<User>(new User(), HttpStatus.BAD_REQUEST);
	}
}

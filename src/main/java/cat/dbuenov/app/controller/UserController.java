package cat.dbuenov.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cat.dbuenov.app.model.User;
import cat.dbuenov.app.service.ServiceMongoDB;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	ServiceMongoDB service;
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return new ResponseEntity<User> (service.addUser(user),HttpStatus.CREATED);		
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable String id){
		return new ResponseEntity<User> (service.deleteUser(id),HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable String id){
		return new ResponseEntity<User> (service.getUser(id),HttpStatus.OK);		
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> changeUser(@PathVariable String id, @RequestBody User user) {
		return new ResponseEntity<User> (service.changeUser(id, user),HttpStatus.OK);		
	}
		
}

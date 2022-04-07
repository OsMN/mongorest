package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.demo.documentos.User;
import com.example.demo.interfaces.IUserService;


@RequestMapping("/Usuario")
@RestController
public class ControladorUser {

	@Autowired
	IUserService userservice;

	@GetMapping("/list_all")
	public ArrayList<User> get_users() {
		return userservice.list_all();
	}

	@PostMapping("/add")
	public int add_user(@RequestBody User user) {
		User user1 = userservice.search_user_by_id(user.getId());
		if (user1 == null) {
			userservice.add(user);
			return 0;
		} else {
			return 1;
		}
	}

	@GetMapping("/find_user_by_id/{id}")
	public User get_user_by_id(@PathVariable("id") int id) {
		User user1 = userservice.search_user_by_id(id);
		if (user1.getNombre().equals(null)) {
			return new User();
		} else {
			return user1;
		}
	}

	@DeleteMapping("/delete_user_by_id/{id}")
	public Integer delete_user_by_id(@PathVariable("id") int id) {
		User user1 = userservice.search_user_by_id(id);
		if (user1.getNombre().equals(null)) {
			return 1;
		} else {
			userservice.delete_user_by_id(id);
			return 0;
		}
	}
	
//Añado esta linea como prueba para jenkins
	@PutMapping("/update")
	public Integer update_libro(@RequestBody User user) {
		User user1 = userservice.search_user_by_id(user.getId());
		if (user1.getNombre().equals(null)) {
			return 1;
		} else {
			userservice.modify_user(user);
			return 0;
		}
	}
}

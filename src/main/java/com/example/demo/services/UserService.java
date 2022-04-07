package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.documentos.User;
import com.example.demo.interfaces.IUserService;
import com.example.demo.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userrepository;
	
	@Override
	public void add(User user) {
		userrepository.save(user);
	}

	@Override
	public ArrayList<User> list_all() {
		// TODO Auto-generated method stub
		return (ArrayList<User>) userrepository.findAll();
	}
	@Override
	public void modify_user(User user) {
		userrepository.save(user);
	}
	@Override
	public void delete_user_by_id(int id) {
		userrepository.deleteById(id);
	}
	@Override
	public User search_user_by_id(int id) {
		return userrepository.findById(id).orElse(null);
	}
}

package com.example.demo.interfaces;

import java.util.ArrayList;

import com.example.demo.documentos.User;

public interface IUserService {
	
	public void add(User user);
	public ArrayList<User> list_all();
	void modify_user(User user);
	void delete_user_by_id(int id);
	User search_user_by_id(int id);
}

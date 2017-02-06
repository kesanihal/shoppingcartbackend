package com.niit.shoppingcartbackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcartbackend.model.User;

@Repository
public interface UserDAO {
	public boolean saveOrUpdate(User user);

	public boolean delete(User user);

	public List<User> list();

	public User get(int id);


	public User validate(String username, String password);

	public User get(String username);
}

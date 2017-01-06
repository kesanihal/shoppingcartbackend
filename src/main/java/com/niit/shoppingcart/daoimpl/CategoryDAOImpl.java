package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Category;

public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactor){
		
		this.sessionFactory=sessionFactory;
	}

	public List<Category> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public Category get(String id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class,id);
		
	}

	public Category validate(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean save(Category category) {
		
		try{
		sessionFactory.getCurrentSession().save(category);
		}catch(Exception e){
			e.printStackTrace();
		return false;
		}
		return true;
	}

	public boolean update(Category category) {
		
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
}

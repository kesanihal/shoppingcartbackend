package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Product;

public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactor){
		
		this.sessionFactory=sessionFactory;
	}

	public List<Product> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public Product get(String id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class,id);
		
	}

	public Product validate(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean save(Product product) {
		
		try{
		sessionFactory.getCurrentSession().save(product);
		}catch(Exception e){
			e.printStackTrace();
		return false;
		}
		return true;
	}

	public boolean update(Product product) {
		
		try {
			sessionFactory.getCurrentSession().update(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
}

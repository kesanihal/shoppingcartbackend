package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Supplier;

public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SupplierDAOImpl(SessionFactory sessionFactor){
		
		this.sessionFactory=sessionFactory;
	}

	public List<Supplier> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public Supplier get(String id) {
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class,id);
		
	}

	public Supplier validate(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean save(Supplier supplier) {
		
		try{
		sessionFactory.getCurrentSession().save(supplier);
		}catch(Exception e){
			e.printStackTrace();
		return false;
		}
		return true;
	}

	public boolean update(Supplier supplier) {
		
		try {
			sessionFactory.getCurrentSession().update(supplier);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
}

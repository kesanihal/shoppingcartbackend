package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactor){
		
		this.sessionFactory=sessionFactory;
	}

	@SuppressWarnings({"rawtypes","unchecked","deprecation"})
	@Transactional
	public List<User> list() {
		String hql="from user";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		// TODO Auto-generated method stub
		return query.list();
	}
@Transactional
	public User get(String id) {
		return (User) sessionFactory.getCurrentSession().get(User.class,id);
		
	}

@SuppressWarnings({ "deprecation", "rawtypes" })
	@Transactional
	public User validate(String id, String password) {
		String hql="from OSUser where id='"+id+"' and password='"+password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (User)query.uniqueResult();
	}

   @Transactional
	public boolean save(User user) {
		try{
		  sessionFactory.getCurrentSession().save(user);
		}
		catch (Exception e){
			e.printStackTrace();
			//This is used to know the error which will be displayed in the console. 
			return false;
		}
		return true;
	}

	@Transactional
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}

	//public static boolean isValidCredentials(String id, String password) {
		// TODO Auto-generated method stub
		//return false;
	//}
	
}
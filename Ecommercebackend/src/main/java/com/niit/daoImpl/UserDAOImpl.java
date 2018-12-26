package com.niit.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDAO;
import com.niit.model.User;




@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	

	public boolean save(User user) {
		try
		{
		sessionFactory.getCurrentSession().save(user);
		
		}catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean update(User user) {
		try
		{
		sessionFactory.getCurrentSession().update(user);
		}catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public boolean validate(String id, String password) {
		
		
	Query query=	 sessionFactory.getCurrentSession().createQuery(" from User where id = ? and password = ?");
	query.setString(0, id);     
	query.setString(1, password);
	
	 if(  query.uniqueResult()  == null)
	 { 
		 return false;
	 }
	 else
	 {
		 return true;
	 }
	
	}

	public List<User> list() {
		
		
		return  sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User get(String id) {
		
		
	  return 	(User)  sessionFactory.getCurrentSession().get(User.class, id);
		
	}

}

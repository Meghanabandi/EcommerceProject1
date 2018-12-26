package com.niit.daoImpl;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CartDAO;
import com.niit.model.Cart;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean save(Cart cart) {
		try {
			sessionFactory.getCurrentSession().save(cart);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getCartById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Cart> list(String emailID) {
		// select * from cart where emailID=?
		return sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.add(Restrictions.eqOrIsNull("emailID", emailID)).list();
	}

	public Cart getCartById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Cart getCartByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.vwits.OEP.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.vwits.OEP.model.Users;

@Component
public class UserDAO {
	Configuration cfg;
	SessionFactory factory;
	Session session;
	Transaction tx;
	
	public void registerUser(Users u) {
		boolean userRegistered = false;
		
		cfg = new Configuration();
		factory = cfg.configure().addAnnotatedClass(Users.class).buildSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
		
		session.save(u);
		tx.commit();
		session.close();
		factory.close();
	}
	
	public Users getUsername(String username) {
		cfg = new Configuration();
		factory = cfg.configure().addAnnotatedClass(Users.class).buildSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Users.class);
		c.add(Restrictions.eq("username", username));
		List userList = c.list();
		Users registeredUser = null;
		//System.out.println(userList);
		if(userList.size() != 0) {
			registeredUser = (Users) userList.get(0);
			return registeredUser;
			
		}else {
			registeredUser = null;
		}
		
		tx.commit();
		session.close();
		factory.close();
		
		return registeredUser;
		
	}

}

package com.personal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class LoginImpl implements Login {
	@Autowired
	private SessionFactory sessionFactory;
  
  

	@Override
	public boolean validateUser(String email, String password) {
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		//Query using Hibernate Query Language
		String SQL_QUERY =" from User as o where o.email=? and o.password=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, email);
		query.setParameter(1, password);
		List list = query.list();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			}

		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}

		session.close();
		return userFound;              
	}

}

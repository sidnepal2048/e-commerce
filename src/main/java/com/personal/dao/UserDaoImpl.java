package com.personal.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.personal.entity.Authorities;
import com.personal.entity.User;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@Transactional
	public void addUser(User user) {
		Session session = sessionFactory.openSession();
		user.setEnabled(true);
		session.saveOrUpdate(user);
		Authorities authorities = new Authorities();
		authorities.setAuthority("ROLE_USER");
		authorities.setEmail(user.getEmail());
		session.saveOrUpdate(authorities);
		session.flush();

	}

}

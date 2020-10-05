package com.personal.dao;

import com.personal.entity.Country;
import com.personal.entity.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class CountryDaoImpl implements CountryDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Country> getAllCountry() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from CCTL_COUNTRY");
        List<Country> country = query.list();
        session.flush();
        return country;
    }
}

package com.personal.dao;

import com.personal.entity.State;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StateDaoImpl implements StateDao {
  @Autowired private SessionFactory sessionFactory;

  @Override
  public List<State> getAllState() {
    Session session = sessionFactory.openSession();
    Query query = session.createQuery("from CCTL_STATE");
    List<State> state = query.list();
    session.flush();
    return state;
  }
}

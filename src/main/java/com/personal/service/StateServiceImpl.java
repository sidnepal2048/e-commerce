package com.personal.service;

import com.personal.dao.StateDao;
import com.personal.entity.State;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl implements StateService {
  @Autowired private StateDao stateDao;

  @Override
  public List<State> getAllState() {
    return stateDao.getAllState();
  }
}

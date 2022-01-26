package com.personal.service;

import com.personal.dao.CountryDao;
import com.personal.entity.Country;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
  @Autowired private CountryDao countryDao;

  @Override
  public List<Country> getAllCountry() {
    return countryDao.getAllCountry();
  }
}

package com.personal.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.personal.controller.HomeController;
import java.text.DateFormat;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

public class HomeControllerTest {
  public Model model;

  @BeforeEach
  void initMocks() {
    model = new ExtendedModelMap();
    MockitoAnnotations.initMocks(this);
  }

  @InjectMocks private HomeController homeController;

  @Test
  public void test_home() {
    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
    String expectedDate = dateFormat.format(date);

    String returnUrl = homeController.home(model);
    assertEquals("home", returnUrl);

    String returnedDate = (String) model.asMap().get("serverTime");
    assertEquals(returnedDate, expectedDate);
  }
}

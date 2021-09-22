package com.personal.controller.test;

import com.personal.controller.UserController;
import com.personal.dao.UserDao;
import com.personal.dao.UserDaoImpl;
import com.personal.entity.BillingAddress;
import com.personal.entity.ShippingAddress;
import com.personal.entity.User;
import com.personal.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;
import static org.junit.Assert.assertThat;

public class UserControllerTest {
    public Model model;

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserDaoImpl userDao;

    @BeforeEach
    void initMocks() {
        model = new ExtendedModelMap();
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    private UserController userController;

    private User generateUser() {
        User user = new User();
        user.setFname("sid");
        user.setLname("nepal");
        user.setPhone("9136337028");
        user.setEmail("siddharthanepal@gmail.com");
        return user;
    }

    @Test
    public void test_userRegisterModel() {
        User expectedUser = new User();
        BillingAddress ba = new BillingAddress();
        ShippingAddress sa = new ShippingAddress();
        expectedUser.setShippingAddress(sa);
        expectedUser.setBillingAddress(ba);
        String expectedFirstName = expectedUser.getFname();
        String expectedLastName = expectedUser.getLname();

        String returnUrl = userController.register(model);
        assertEquals("registerCustomer", returnUrl);

        User returnedUser = (User) model.asMap().get("user");
        String returnedFirstName= returnedUser.getFname();
        String returnedLastName = returnedUser.getLname();
        assertEquals(returnedFirstName, expectedFirstName);
        assertEquals(returnedLastName, expectedLastName);
    }

    @Test
    public void test_registerCustomerPost() {
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(true);

        String returnUrl = userController.registerCustomerPost(generateUser(), result, model);
        assertEquals("registerCustomer", returnUrl);

        User savedUser = userService.addUser(generateUser());

        verify(userDao).addUser(any(User.class));
    }

}

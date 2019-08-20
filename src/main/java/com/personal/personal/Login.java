package com.personal.personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.personal.entity.User;
import com.personal.service.LoginService;

@Controller

public class Login {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(Model model) {
		User user = new User();
		model.addAttribute(user);
		return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@Transactional
    public String loginPost(@RequestParam("email")String email, @RequestParam("password")String password, @ModelAttribute("user") User user, BindingResult result, Model model) {
		String msg = "";
        boolean isValid = loginService.validateUser(email, password);
        if(isValid) {
        	msg = "Welcome" + email;
        }
      // System.out.println(email);
        return "user_page";


    }

}

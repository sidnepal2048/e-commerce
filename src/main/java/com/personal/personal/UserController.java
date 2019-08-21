package com.personal.personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.personal.entity.User;
import com.personal.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value= "/register", method = RequestMethod.GET)
	@Transactional
	public String register(Model model){
		User user = new User();
		model.addAttribute("user", user);
		return "registerCustomer";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@Transactional
    public String registerCustomerPost(@ModelAttribute("user") User user, BindingResult result,
                                       Model model) {

        if (result.hasErrors()) {
            return "registerCustomer";
        }
   
        userService.addUser(user);
        return "redirect:/";

    }
	

}

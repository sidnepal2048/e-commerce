package com.personal.controller;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.personal.entity.Product;
import com.personal.entity.User;
import com.personal.service.ProductService;
import com.personal.service.UserService;



@Controller

public class Login{
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error, @RequestParam(value="logout",
            required = false) String logout, Model model) {
        if (error!=null) {
            model.addAttribute("error", "Invalid username and password");
        }

        if(logout!=null) {
            model.addAttribute("msg", "You have been logged out successfully.");
        }

        return "login";
    }
	
    @Controller
    @RequestMapping("/SignOut")
    public class SignOutController {

      @RequestMapping(method=RequestMethod.GET)
      public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
      }
    }

    @RequestMapping("/success")
	@Transactional
	public String success() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		String redirectUrl = null;
		for (GrantedAuthority grantedAuthority : authorities) {
			System.out.println("role " + grantedAuthority.getAuthority());
			if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
				redirectUrl = "redirect:/homepage";
			} else {
				redirectUrl = "redirect:/Admin";
			}
			break;
		}
		return redirectUrl;
	}
	
	@RequestMapping("/homepage")
	@Transactional
	public String homepage(Model model){
		List<Product> product = productService.getAllProduct();
		Iterator<Product> itr = product.listIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		model.addAttribute("products", product);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String emailId = userDetails.getUsername();
		System.out.println(emailId);
		User user;
		user = userService.getUserByEmail(emailId);
		int cartid = user.getCart().getCartId();
		System.out.println(cartid);
		model.addAttribute("cartId", user.getCart().getCartId());
		return "user_page";
	}
}

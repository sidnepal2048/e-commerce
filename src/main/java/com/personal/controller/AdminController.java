package com.personal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.personal.entity.Product;
import com.personal.entity.User;
import com.personal.service.ProductService;
import com.personal.service.UserService;

@Controller
public class AdminController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/Admin")
	public String admin_home() {
		return "dashboard";
	}
	
	@RequestMapping("/Admin/addProduct")
	public String addProduct(Model model){
		Product product = new Product();
		model.addAttribute("product", product);
		return "admin_home";
	}
	
	@RequestMapping(value="/Admin/addProduct", method=RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product") Product product, BindingResult result){
		if(result.hasErrors()){
			return "admin_home";
		}
		 
		productService.addProduct(product);
		return "redirect:/Admin";
	}
	
	@RequestMapping("/Admin/getAllProduct")
	public String getAllProduct(Model model) {
		List<Product> product = productService.getAllProduct();
		model.addAttribute("products", product);
		return "productDashboard";
	}
	
	@RequestMapping("/Admin/getAllCustomer")
	public String getAllUser(Model model) {
		/*List<User> product = userService.getAllUser();
		model.addAttribute("products", product);		
		return "user-list";*/
		
		model.addAttribute("user", new User());
		model.addAttribute("user", this.userService.getAllUser());
		return "user-list";

	}

}


package com.personal.personal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.personal.entity.Product;
import com.personal.service.ProductService;

@Controller
public class AdminController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/homepage/Admin")
	public String admin_home() {
		return "admin_home1";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(Model model){
		Product product = new Product();
		model.addAttribute("product", product);
		return "admin_home";
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product") Product product, BindingResult result, Model model, HttpServletRequest request){
		if(result.hasErrors()){
			return "admin_home";
		}
		 
		productService.addProduct(product);
		return "redirect:/homepage/Admin";
	}

}


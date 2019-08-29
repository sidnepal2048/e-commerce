package com.personal.personal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.personal.entity.BillingAddress;
import com.personal.entity.Cart;
import com.personal.entity.CartItem;
import com.personal.entity.Product;
import com.personal.entity.ShippingAddress;
import com.personal.entity.User;
import com.personal.service.CartItemService;
import com.personal.service.CartService;
import com.personal.service.EmailService;
import com.personal.service.ProductService;
import com.personal.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@RequestMapping(value= "/register", method = RequestMethod.GET)
	@Transactional
	public String register(Model model){
		User user = new User();
		BillingAddress ba = new BillingAddress();
		ShippingAddress sa = new ShippingAddress();
		user.setShippingAddress(sa);
		user.setBillingAddress(ba);
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
        String to = user.getEmail();
        String subject = "Registered";
        String message = "Congratulation you are registered";
        emailService.sendEmailToUser(to, subject, message);
        return "redirect:/";

    }
	
	@RequestMapping("/account")
	@Transactional
	public String account(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		User user = new User();
		user = userService.getUserByEmail(userDetails.getUsername());
		String fname = user.getFname();
		String lname = user.getLname();
		String phone = user.getPhone();
		String email = userDetails.getUsername();
		model.addAttribute("fname", fname);
		model.addAttribute("lname", lname);
		model.addAttribute("phone", phone);
		model.addAttribute("email", email);
		//model.addAttribute("user1", this.userService.getUserByEmail(userDetails.getUsername()));
		return "account";
	}
	
	@RequestMapping("/getProductById/{productId}")
	@Transactional
	public String getProductById(@PathVariable(value = "productId") int productId, Model model) {
		Product products = productService.getProductById(productId);
		model.addAttribute("products", products);
		return "";
	}
	
	@RequestMapping("/addToCart/{productId}")
	@Transactional
	public String addToCart(@PathVariable(value = "productId") int productId, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		User user = new User();
		String email = userDetails.getUsername();
		user = userService.getUserByEmail(email);
		Cart cart = user.getCart();
		List<CartItem> cartItems = cart.getCartItem();
		Product product = productService.getProductById(productId);
		for (int i = 0; i < cartItems.size(); i++) {
			CartItem cartItem = cartItems.get(i);
			if (product.getProductId() == cartItem.getProduct().getProductId()) {
				cartItem.setQuality(cartItem.getQuality() + 1);
				cartItem.setPrice(cartItem.getQuality() * cartItem.getProduct().getProductPrice());
				cartItemService.addCartItem(cartItem);
			}
		}
		CartItem cartItem = new CartItem();
		cartItem.setQuality(1);
		cartItem.setProduct(product);
		cartItem.setPrice(product.getProductPrice() * 1);
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);
		return "redirect:/homepage";
	}
	
	@RequestMapping("/cart/getCartId/{cartId}")
	@Transactional
	public String getCartId(Model model, @PathVariable(value = "cartId") int cartId){
		//CartItem cartItem;
		List<CartItem> cartItem = cartItemService.getCartItem(cartId);
		model.addAttribute("cartItem", cartItem);
		int cartItemId=0;
		for(int i=0; i<cartItem.size();i++) {
			cartItemId = cartItem.get(i).getCartItemId();
			System.out.println("Cart Item Id:" + cartItemId);
			model.addAttribute("cartItemId", cartItemId);
		}
		Cart cart = cartService.getCartByCartId(cartId);
		double price = cartService.update(cart);
		model.addAttribute("price", price);
		//System.out.println("Cart item id:" + cartItemId);
		return "cart";
	}
	
	@RequestMapping("/cart/removeCartItem/{cartItemId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeCartItem(@PathVariable(value = "cartItemId") int cartItemId) {
		cartItemService.removeCartItem(cartItemId);
	}

	@RequestMapping("/cart/removeAllItem/{cartId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public String removeAllCartItems(@PathVariable(value = "cartId") int cartId) {
		Cart cart = cartService.getCartByCartId(cartId);
		//System.out.println("Cart Id:" + cart.getCartId());
		cartItemService.removeAllCartItems(cart);
		return "redirect:/homepage";
	}

	
}

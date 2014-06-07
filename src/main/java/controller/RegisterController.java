package controller;

import model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
	
	@RequestMapping(value="/register.html")
	public ModelAndView user() {
		System.out.println("aaa");
	    return new ModelAndView("register", "command", new User());
	}	 
	
	@RequestMapping(value="/register.html", method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("User")User user) {
		System.out.println("bbb");
	    return new ModelAndView("register", "command", new User());
	}	 
	
}

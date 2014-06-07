package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.api.IUserService;

@Controller
public class LoginController {
	@Autowired 
	private IUserService userService;
	
	@RequestMapping(value={"/", "/index.html"})
	public ModelAndView list(ModelAndView model) {
		model.addObject("users", userService.getAll());
		model.setViewName("index");
		
	    return model;
	}	 	
}

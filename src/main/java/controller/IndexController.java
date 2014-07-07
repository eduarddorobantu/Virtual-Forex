package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.api.ICurrencyService;
import service.api.INewsService;
import service.api.IUserService;

@Controller
public class IndexController {
	@Autowired 
	private IUserService userService;
	@Autowired 
	private ICurrencyService currencyService;
	@Autowired 
	private INewsService newsService;
	
	@RequestMapping(value={"/", "/index.html"}, params={"!login", "!logout", "!buy_currency"})
	public ModelAndView list(ModelAndView model) {
		model.addObject("users", userService.getAll());
		model.addObject("availableCurrencies", currencyService.getAll());
		model.addObject("availableNews", newsService.getAll());
		model.setViewName("index");
		
	    return model;
	}	 	
}

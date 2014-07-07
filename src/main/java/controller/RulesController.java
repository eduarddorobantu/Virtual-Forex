package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.api.ICurrencyService;
import service.api.INewsService;

@Controller
public class RulesController {
	@Autowired 
	private ICurrencyService currencyService;
	@Autowired 
	private INewsService newsService;
	
	@RequestMapping(value={"/rules.html"})
	public ModelAndView list(ModelAndView model) {
		model.setViewName("rules");
		model.addObject("availableCurrencies", currencyService.getAll());
		
	    return model;
	}	 	
}

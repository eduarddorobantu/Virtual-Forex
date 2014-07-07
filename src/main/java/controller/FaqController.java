package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.api.ICurrencyService;
import service.api.INewsService;

@Controller
public class FaqController {
	@Autowired 
	private ICurrencyService currencyService;
	@Autowired 
	private INewsService newsService;
	
	@RequestMapping(value={"/faq.html"})
	public ModelAndView get() {
		ModelAndView mv = new ModelAndView("faq");
		mv.addObject("availableCurrencies", currencyService.getAll());
		
	    return mv;
	}	 	
}

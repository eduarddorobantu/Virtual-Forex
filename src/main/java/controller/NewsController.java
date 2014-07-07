package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.api.ICurrencyService;
import service.api.INewsService;

@Controller
public class NewsController {
	@Autowired 
	private ICurrencyService currencyService;
	@Autowired 
	private INewsService newsService;
	
	@RequestMapping(value={"/news.html"}, params={"!login", "!logout"})
	public ModelAndView list() {
		
		ModelAndView mv = new ModelAndView("news");
		mv.addObject("availableCurrencies", currencyService.getAll());
		mv.addObject("availableNews", newsService.getAll());
		mv.addObject("allNews", "");

	    return mv;
	}	 			
	
	@RequestMapping(value={"/news/{id}.html"})
	public ModelAndView listCharts(ModelAndView model, @PathVariable("id") String id, HttpServletRequest request) {
		String title = request.getRequestURI().substring(12, request.getRequestURI().length() - 5);
		title = title.replaceAll("%20", " ");
		
		ModelAndView mv = new ModelAndView("news");
		mv.addObject("availableCurrencies", currencyService.getAll());
		mv.addObject("availableNews", newsService.getAll());
		
		mv.addObject("news", newsService.getByTitle(title));
		
		return mv;	
	}	 	
}

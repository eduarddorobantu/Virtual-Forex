package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import model.Currency;
import model.Silo;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.api.ICurrencyService;
import service.api.INewsService;
import service.api.ISiloService;

@Controller
public class SiloController {
	@Autowired 
	private ISiloService siloService;
	@Autowired 
	private ICurrencyService currencyService;
	@Autowired 
	private INewsService newsService;
	
	@RequestMapping(value={"/my_silos.html"})
	public ModelAndView list(HttpSession session) {
		User user = (User)session.getAttribute("user");
		List<Silo> silos = siloService.getByUserId(user.getId());
		Map<Integer, Currency> currencies = new HashMap<Integer, Currency>();
		
		for (Silo silo : silos) {
			Currency currency = currencyService.getById(silo.getCurrency());
			currencies.put(silo.getId(), currency);
		}		
		
		ModelAndView mv = new ModelAndView("silos");
		mv.addObject("silos", silos);
		mv.addObject("currencies", currencies);
		mv.addObject("availableCurrencies", currencyService.getAll());
		
	    return mv;
	}	 	
}

package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

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
import service.api.IUserService;
import converter.YahooCurrencyConverter;

@Controller
public class RankingController {
	@Autowired 
	private ICurrencyService currencyService;
	@Autowired 
	private INewsService newsService;
	@Autowired 
	private IUserService userService;
	@Autowired 
	private ISiloService siloService;
	@Autowired 
	private YahooCurrencyConverter yahooConverterService;
	
	
	@RequestMapping(value={"/ranking.html"})
	public ModelAndView list() throws IOException {
		Map<String, List<Double>> usersRankingAll = new HashMap<String, List<Double>>();		//for all the currencies
		Map<String, Double> usersRanking = new TreeMap<String, Double>();
		
		List<User> users = userService.getAll();
		List<Currency> currencies = currencyService.getAll();
		List<Double> currenciesValues = new ArrayList<Double>();
		for (Currency currency : currencies)
			currenciesValues.add(yahooConverterService.convert(currency.getCode(), "USD"));

		for (User user : users) {
			List<Silo> silos = siloService.getByUserId(user.getId());
			List<Double> siloValues = new ArrayList<Double>();

			double totalValue = 0;
			for (int i = 0; i < silos.size(); i++) {
				double valueInUSD = silos.get(i).getAmount() * currenciesValues.get(i);
				totalValue += valueInUSD;
				
				siloValues.add(valueInUSD);
			}
			
			usersRankingAll.put(user.getName(), siloValues);
			usersRanking.put(user.getName(), totalValue);
		}
		
		List<Map.Entry<String, Double>> usersRankingSorted = new ArrayList<Map.Entry<String,Double>>(usersRanking.entrySet());
		Collections.sort(usersRankingSorted, new Comparator<Map.Entry<String, Double>>() {

			public int compare(Entry<String, Double> o1,
					Entry<String, Double> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
			
		});
		
		ModelAndView mv = new ModelAndView("ranking");
		mv.addObject("availableCurrencies", currencyService.getAll());
		mv.addObject("availableNews", newsService.getAll());
		mv.addObject("usersRankingSorted", usersRankingSorted);
		mv.addObject("usersRankingAll", usersRankingAll);
		
	    return mv;
	}	 	
}

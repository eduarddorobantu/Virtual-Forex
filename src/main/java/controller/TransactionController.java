package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Currency;
import model.Transaction;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.api.ICurrencyService;
import service.api.INewsService;
import service.api.ITransactionService;
import service.api.IUserService;

@Controller
public class TransactionController {
	@Autowired 
	private ITransactionService transactionService;
	@Autowired 
	private ICurrencyService currencyService;
	@Autowired 
	private IUserService userService;
	@Autowired 
	private INewsService newsService;
	
	@RequestMapping(value={"/transactions.html"})
	public ModelAndView list() {
		List<Transaction> transactions = transactionService.getAll();
		Map<Integer, Currency> currenciesFrom = new HashMap<Integer, Currency>();
		Map<Integer, Currency> currenciesTo = new HashMap<Integer, Currency>();
		Map<Integer, User> users = new HashMap<Integer, User>();
		List<User> allUsers = userService.getAll();
		
		for (Transaction transaction : transactions) {
			User user = userService.getById(transaction.getUser());
			Currency currencyFrom = currencyService.getById(transaction.getFromCurrency());
			Currency currencyTo = currencyService.getById(transaction.getToCurrency());

			users.put(transaction.getId(), user);
			currenciesFrom.put(transaction.getId(), currencyFrom);
			currenciesTo.put(transaction.getId(), currencyTo);
		}
		
		ModelAndView mv = new ModelAndView("transactions");
		mv.addObject("transactions", transactions);
		mv.addObject("users", users);
		mv.addObject("currenciesFrom", currenciesFrom);
		mv.addObject("currenciesTo", currenciesTo);
		mv.addObject("allUsers", allUsers);
		mv.addObject("availableCurrencies", currencyService.getAll());
		
	    return mv;
	}	 	
	
	@RequestMapping(value={"/transactions/{username}.html"})
	public ModelAndView listByUsername(@PathVariable("username") String username) {
		User selectedUser = userService.getByUsername(username);
		List<Transaction> transactions = transactionService.getByUserId(selectedUser.getId());
		Map<Integer, Currency> currenciesFrom = new HashMap<Integer, Currency>();
		Map<Integer, Currency> currenciesTo = new HashMap<Integer, Currency>();
		Map<Integer, User> users = new HashMap<Integer, User>();
		List<User> allUsers = userService.getAll();
		
		for (Transaction transaction : transactions) {
			User user = userService.getById(transaction.getUser());
			Currency currencyFrom = currencyService.getById(transaction.getFromCurrency());
			Currency currencyTo = currencyService.getById(transaction.getToCurrency());

			users.put(transaction.getId(), user);
			currenciesFrom.put(transaction.getId(), currencyFrom);
			currenciesTo.put(transaction.getId(), currencyTo);
		}
		
		ModelAndView mv = new ModelAndView("transactions");
		mv.addObject("transactions", transactions);
		mv.addObject("users", users);
		mv.addObject("currenciesFrom", currenciesFrom);
		mv.addObject("currenciesTo", currenciesTo);
		mv.addObject("allUsers", allUsers);
		mv.addObject("selectedUser", selectedUser);
		mv.addObject("availableCurrencies", currencyService.getAll());
		
	    return mv;
	}	 	
}

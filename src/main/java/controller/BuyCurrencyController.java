package controller;

import java.net.URI;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Log;
import model.Silo;
import model.Transaction;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.api.ICurrencyService;
import service.api.ILogService;
import service.api.INewsService;
import service.api.ISiloService;
import service.api.ITransactionService;

@Controller
public class BuyCurrencyController {
	@Autowired 
	private ICurrencyService currencyService;
	@Autowired 
	private INewsService newsService;
	@Autowired 
	private ITransactionService transactionService;
	@Autowired 
	private ISiloService siloService;
	@Autowired 
	private ILogService logService;

	@RequestMapping(value= "*", method = RequestMethod.POST, params={"buy_currency"})
	public ModelAndView list(HttpServletRequest request, 
			HttpSession session) {
		User user = (User)session.getAttribute("user");
		Map<String, String[]> parameters = request.getParameterMap();
		Transaction transaction = new Transaction();
		
	    for(String key : parameters.keySet()) {	    	
	    	if (key.equals("from_currency"))
	    		transaction.setFromCurrency(Integer.parseInt(parameters.get(key)[0]));
	    	else if (key.equals("to_currency"))
	    		transaction.setToCurrency(Integer.parseInt(parameters.get(key)[0]));
	    	else if (key.equals("amount_from_currency"))
	    		transaction.setAmountFromCurrency(Double.parseDouble(parameters.get(key)[0]));
	    	else if (key.equals("amount_to_currency"))
	    		transaction.setAmountToCurrency(Double.parseDouble(parameters.get(key)[0]));
	    }
	    transaction.setUser(user.getId());
	    transaction = transactionService.saveTransaction(transaction);
	    
	    
	    Silo siloFrom = siloService.getByUserAndCurrency(transaction.getUser(), transaction.getFromCurrency());
	    Silo siloTo = siloService.getByUserAndCurrency(transaction.getUser(), transaction.getToCurrency());
	    siloFrom.setAmount(siloFrom.getAmount() - transaction.getAmountFromCurrency());
	    siloTo.setAmount(siloTo.getAmount() + transaction.getAmountToCurrency());
	    siloService.saveOrUpdateSilo(siloFrom);
	    siloService.saveOrUpdateSilo(siloTo);
	    
	    
	    Log log = new Log();
	    log.setOperation("transaction");
	    log.setTransaction(transaction.getId());
	    log.setUser(transaction.getUser());
	    logService.saveLog(log);
	    
	    
	    String URI = request.getHeader("referer");
	    int position = URI.lastIndexOf("/") + 1;
	    String view = URI.substring(position);
	    
	    if (view.equals(""))
	    	view = "index";
	    else
	    	view = view.substring(0, view.length() - 5);
	    
	    ModelAndView mv = new ModelAndView(view);
		
	    mv.addObject("availableCurrencies", currencyService.getAll());
	    mv.addObject("availableNews", newsService.getAll());
		
	    return mv;
	}	 	
}

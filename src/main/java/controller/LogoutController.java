package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.api.ICurrencyService;
import service.api.INewsService;
import service.api.IUserService;

@Controller
public class LogoutController {
	@Autowired 
	private ICurrencyService currencyService;
	@Autowired 
	private INewsService newsService;
	
	@RequestMapping(value="*", params={"logout"})
	public ModelAndView logout(HttpServletRequest request, 
			HttpSession session) {
		
		session.removeAttribute("user");
		
	    String URI = request.getHeader("referer");
	    int position = URI.lastIndexOf("/") + 1;
	    String view = URI.substring(position);
	    
	    if (view.equals(""))
	    	view = "index";
	    else
	    	view = view.substring(0, view.length() - 5);
	    
	    ModelAndView mv = new ModelAndView(view);
	    mv.addObject("availableCurrencies", currencyService.getAll());
	    
	    return mv;
	    
	}	 	
}

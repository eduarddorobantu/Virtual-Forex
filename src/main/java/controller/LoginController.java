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
import service.api.IUserService;

@Controller
public class LoginController {
	@Autowired 
	private IUserService userService;
	@Autowired 
	private ICurrencyService currencyService;
	
	@RequestMapping(value= "*", method = RequestMethod.POST, params={"login"})
	public ModelAndView login(HttpServletRequest request, 
			HttpSession session) {
		Map<String, String[]> parameters = request.getParameterMap();
		String username = "", password = "";
		
	    for(String key : parameters.keySet()) {	    	
	    	if (key.equals("username"))
	    		username = parameters.get(key)[0];
	    	else if (key.equals("password"))
	    		password = parameters.get(key)[0];
	    }
	    
	    User user = userService.loginUser(username, password);
	    String URI = request.getHeader("referer");
	    int position = URI.lastIndexOf("/") + 1;
	    String view = URI.substring(position);
	    
	    if (view.equals(""))
	    	view = "index";
	    else
	    	view = view.substring(0, view.length() - 5);
	    
	    ModelAndView mv = new ModelAndView(view);
	    
	    if (user != null) {
	    	session.setAttribute("user", user);
	    	mv.addObject("login_success", "success");
	    }
	    else
	    	mv.addObject("login_fail", "fail");
	    
	    mv.addObject("availableCurrencies", currencyService.getAll());
	    
	    return mv;
	    
	}	 	
}

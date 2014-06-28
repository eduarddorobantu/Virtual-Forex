package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.Country;
import model.SecurityQuestion;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.api.ICountryService;
import service.api.ICurrencyService;
import service.api.ISecurityQuestionService;
import service.api.IUserService;

@Controller
public class RegisterController {
	@Autowired 
	private IUserService userService;
	@Autowired 
	private ICountryService countryService;
	@Autowired 
	private ISecurityQuestionService securityQuestionService;
	@Autowired 
	private ICurrencyService currencyService;
	
	@RequestMapping(value="/register.html", params={"!login", "!logout"})
	public ModelAndView register() {
		List<Country> countries = countryService.getAll();
		List<SecurityQuestion> securityQuestions = securityQuestionService.getAll();
		
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("countries", countries);
		mv.addObject("securityQuestions", securityQuestions);
		mv.addObject("availableCurrencies", currencyService.getAll());
		
		return mv;		
	}	 
	
	@RequestMapping(value="/register.html", method=RequestMethod.POST, params={"register"})
	public ModelAndView registerUser(HttpServletRequest request) {
		Map<String, String[]> parameters = request.getParameterMap();
		User user = new User();
		
	    for(String key : parameters.keySet()) {
	    	
	    	if (key.equals("username"))
	    		user.setUsername(parameters.get(key)[0]);
	    	else if (key.equals("password"))
	    		user.setPassword(parameters.get(key)[0]);
	    	else if (key.equals("name"))
	    		user.setName(parameters.get(key)[0]);
	    	else if (key.equals("email"))
	    		user.setEmail(parameters.get(key)[0]);
	    	else if (key.equals("country_id"))
	    		user.setCountryId(Integer.parseInt(parameters.get(key)[0]));
	    	else if (key.equals("security_question_id"))
	    		user.setSecurityQuestionId(Integer.parseInt(parameters.get(key)[0]));
	    	else if (key.equals("security_answer"))
	    		user.setSecurityAnswer(parameters.get(key)[0]);
	    	
	    }
	    
	    user.setRoleId(2);
	    User userRegistered = userService.registerUser(user);
	    
	    List<Country> countries = countryService.getAll();
		List<SecurityQuestion> securityQuestions = securityQuestionService.getAll();
		
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("countries", countries);
		mv.addObject("securityQuestions", securityQuestions);
	    
	    if (userRegistered == null)
			mv.addObject("register_fail", "fail");	    
	    else
			mv.addObject("register_success", "success");
	    mv.addObject("availableCurrencies", currencyService.getAll());
	    
	    return mv;	
	}	 
	
}

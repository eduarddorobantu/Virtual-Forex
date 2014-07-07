package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import service.api.INewsService;
import service.api.ISecurityQuestionService;
import service.api.IUserService;

@Controller
public class EditAccountController {
	@Autowired 
	private IUserService userService;
	@Autowired 
	private ICountryService countryService;
	@Autowired 
	private ISecurityQuestionService securityQuestionService;
	@Autowired 
	private ICurrencyService currencyService;
	@Autowired 
	private INewsService newsService;
	
	@RequestMapping(value="/edit_account.html", params={"!login", "!logout", "!edit_account"})
	public ModelAndView register(HttpSession session) {
		List<Country> countries = countryService.getAll();
		List<SecurityQuestion> securityQuestions = securityQuestionService.getAll();
		User user = (User)session.getAttribute("user");
		
		ModelAndView mv = new ModelAndView("edit_account");
		mv.addObject("countries", countries);
		mv.addObject("securityQuestions", securityQuestions);
		mv.addObject("user", user);
		mv.addObject("availableCurrencies", currencyService.getAll());
		
		return mv;		
	}	 
	
	@RequestMapping(value="/edit_account.html", method=RequestMethod.POST, params={"edit_account"})
	public ModelAndView registerUser(HttpServletRequest request, HttpSession session) {
		Map<String, String[]> parameters = request.getParameterMap();
		User user = (User)session.getAttribute("user");
		
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
	    User userEdited = userService.editUser(user);
	    
	    List<Country> countries = countryService.getAll();
		List<SecurityQuestion> securityQuestions = securityQuestionService.getAll();
		
		ModelAndView mv = new ModelAndView("edit_account");
		mv.addObject("countries", countries);
		mv.addObject("securityQuestions", securityQuestions);
		mv.addObject("user", userEdited);
		
	    if (userEdited == null)
			mv.addObject("edit_fail", "fail");	    
	    else
			mv.addObject("edit_success", "success");
	    mv.addObject("availableCurrencies", currencyService.getAll());
	    
	    return mv;	
	}	 
	
}

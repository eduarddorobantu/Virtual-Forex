package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Message;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.api.ICurrencyService;
import service.api.IMessageService;
import service.api.INewsService;

@Controller
public class ContactController {
	@Autowired
	private IMessageService messageService;
	@Autowired 
	private ICurrencyService currencyService;
	@Autowired 
	private INewsService newsService;
	
	@RequestMapping(value = "/contact.html", method = RequestMethod.GET)
	public ModelAndView contact() {		
		ModelAndView mv = new ModelAndView("contact");
		mv.addObject("availableCurrencies", currencyService.getAll());
		
		return mv;
	}
	   
	@RequestMapping(value = "/contact.html", method = RequestMethod.POST, params={"contact"})
	public ModelAndView sendMessage(HttpServletRequest request, HttpSession session) {
		Map<String, String[]> parameters = request.getParameterMap();
		Message message = new Message();
		
	    for(String key : parameters.keySet()) {
	    	
	    	if (key.equals("title"))
	    		message.setTitle(parameters.get(key)[0]);
	    	else if (key.equals("content"))
	    		message.setContent(parameters.get(key)[0]);
	    	
	    }
		
		User user = (User)session.getAttribute("user");
		if (user != null)
			message.setUser(user.getId());
		
		messageService.saveMessage(message);
		
		ModelAndView mv = new ModelAndView("contact");
		mv.addObject("availableCurrencies", currencyService.getAll());
		mv.addObject("message", message);
	
	    return mv;
	}
}

package controller;

import java.util.List;

import model.Currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.api.ICurrencyService;
import service.api.INewsService;

@Controller
public class ChartsController {
	@Autowired 
	private ICurrencyService currencyService;
	@Autowired 
	private INewsService newsService;
	
	
	private ModelAndView getChartsView(ModelAndView model, String currenciesPair) {
		String embedAddress = "sigDevEnabled=true&amp;changeSymbolEnabled=false&amp;state=symbol=" + currenciesPair + "%3DX;range=1y;compare=;indicator=volume;charttype=area;crosshair=on;ohlcvalues=0;logscale=off;source=;";
		String currency1 = currenciesPair.substring(0, 3);
		String currency2 = currenciesPair.substring(3, currenciesPair.length());
		
		List<Currency> currencies = currencyService.getAll();
		
		model.setViewName("charts");
		model.addObject("currencies", currencies);
		model.addObject("embed_address", embedAddress);
		model.addObject("currency1", currency1);
		model.addObject("currency2", currency2);
		
		model.addObject("availableCurrencies", currencyService.getAll());
		return model;
	}
	
	@RequestMapping(value={"/charts.html"})
	public ModelAndView listInitialCharts(ModelAndView model) {
		
	    return getChartsView(model, "eurusd");
	}	
	
	@RequestMapping(value={"/charts/{id}.html"})
	public ModelAndView listCharts(ModelAndView model, @PathVariable("id") String id) {

		return getChartsView(model, id);
	
	}	 	
	
	@RequestMapping(value={"/chart/{id}.html"})
	public ModelAndView getChart(ModelAndView model, @PathVariable("id") String id) {
		String embedAddress = "sigDevEnabled=true&amp;changeSymbolEnabled=false&amp;state=symbol=" + id + "%3DX;range=1y;compare=;indicator=volume;charttype=area;crosshair=on;ohlcvalues=0;logscale=off;source=;";
		
		model.setViewName("chart");
		model.addObject("currencies", id.toUpperCase());	
		model.addObject("embed_address", embedAddress);	
		model.addObject("availableCurrencies", currencyService.getAll());
		
	    return model;
	}	 	
}

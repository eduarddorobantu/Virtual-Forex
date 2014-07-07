package service.impl;

import java.util.List;

import model.Country;
import model.Currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.api.ICurrencyService;
import dao.CurrencyDao;


@Service
public class CurrencyService implements ICurrencyService {
	@Autowired
	private CurrencyDao currencyDao;
	
	@Transactional
	public List<Currency> getAll() {
		return currencyDao.getAll();
	}
	
	@Transactional
	public Currency getById(int id) {
		return currencyDao.getById(id);
	}
}

package service.impl;

import java.util.List;

import model.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.api.ICountryService;
import dao.CountryDao;


@Service
public class CountryService implements ICountryService {
	@Autowired
	private CountryDao countryDao;
	
	@Transactional
	public List<Country> getAll() {
		return countryDao.getAll();
	}
	
	@Transactional
	public Country getById(int id) {
		return countryDao.getById(id);
	}

}

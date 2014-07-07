package service.api;

import java.util.List;

import model.Country;

public interface ICountryService {

	List<Country> getAll();
	Country getById(int id);
	
}

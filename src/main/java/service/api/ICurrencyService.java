package service.api;

import java.util.List;

import model.Currency;

public interface ICurrencyService {

	List<Currency> getAll();
	Currency getById(int id);
}

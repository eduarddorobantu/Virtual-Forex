package service.api;

import java.util.List;

import model.Silo;

public interface ISiloService {

	List<Silo> getByUserId(int userId);
	Silo getByUserAndCurrency(int userId, int currencyId);
	void saveOrUpdateSilo(Silo silo);
}

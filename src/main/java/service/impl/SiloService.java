package service.impl;

import java.util.List;

import model.Silo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.api.ISiloService;
import dao.SiloDao;


@Service
public class SiloService implements ISiloService {
	
	@Autowired
	private SiloDao siloDao;
	
	@Transactional
	public List<Silo> getByUserId(int userId) {
		return siloDao.getByUserId(userId);
	}

	@Transactional
	public Silo getByUserAndCurrency(int userId, int currencyId) {
		return siloDao.getByUserAndCurrency(userId, currencyId);
	}
	
	@Transactional
	public void saveOrUpdateSilo(Silo silo) {
		siloDao.saveOrUpdateSilo(silo);
	}
}

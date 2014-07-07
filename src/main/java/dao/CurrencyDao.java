package dao;

import java.util.List;

import model.Currency;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class CurrencyDao {
	
	@Autowired 
	private SessionFactory sessionFactory;
   
	public List<Currency> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Currency> currencies = session.createQuery("from Currency").list();
		
		return currencies;
	}
	
	public Currency getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Currency currency = (Currency)session.get(Currency.class, id);
		
		return currency;
	}
  
}
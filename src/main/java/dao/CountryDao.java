package dao;

import java.util.List;

import model.Country;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class CountryDao {
	
	@Autowired 
	private SessionFactory sessionFactory;
   
	public List<Country> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Country> countries = session.createQuery("from Country").list();
		return countries;
	}
	
	public Country getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Country country = (Country)session.get(Country.class, id);
		
		return country;
	}
  
}
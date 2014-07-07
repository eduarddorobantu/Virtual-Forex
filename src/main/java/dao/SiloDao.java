package dao;

import java.util.List;

import model.Silo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class SiloDao {
	
	@Autowired 
	private SessionFactory sessionFactory;
   
	public List<Silo> getByUserId(int userId) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "from Silo silo WHERE silo.user = :userid";
		Query q = session.createQuery(hql);
		q.setParameter("userid", userId);
		List<Silo> silos = q.list();
		
		return silos;
	}
	
	public Silo getByUserAndCurrency(int userId, int currencyId) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "from Silo silo WHERE silo.user = :userid and silo.currency = :currencyid";
		Query q = session.createQuery(hql);
		q.setParameter("userid", userId);
		q.setParameter("currencyid", currencyId);
		List<Silo> silos = q.list();
		
		return silos.get(0);
	}
	
	public void saveOrUpdateSilo(Silo silo) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(silo);
	}
  
}
package dao;

import java.util.List;

import model.Log;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class LogDao {
	
	@Autowired 
	private SessionFactory sessionFactory;
   
	public List<Log> getByUserId(int userId) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "from Log log WHERE log.user = :userid";
		Query q = session.createQuery(hql);
		q.setParameter("userid", userId);
		List<Log> logs = q.list();
		
		return logs;
	}
	
	public List<Log> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Log> logs = session.createQuery("from Log").list();
		
		return logs;
	}
	
	public void saveLog(Log log) {
		Session session = sessionFactory.getCurrentSession();
		
		session.persist(log);
	}
  
}
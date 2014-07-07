package dao;

import model.Message;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDao {
	
	@Autowired 
	private SessionFactory sessionFactory;
  
	public void saveMessage(Message message) {
		Session session = sessionFactory.getCurrentSession();
		
		session.persist(message);
	}
	
}
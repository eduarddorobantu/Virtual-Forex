package dao;

import java.util.List;

import model.SecurityQuestion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class SecurityQuestionDao {
	
	@Autowired 
	private SessionFactory sessionFactory;
   
	public List<SecurityQuestion> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<SecurityQuestion> securityQuestions = session.createQuery("from SecurityQuestion").list();
		
		return securityQuestions;
	}
	
	public SecurityQuestion getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		SecurityQuestion securityQuestion = (SecurityQuestion)session.get(SecurityQuestion.class, id);
		
		return securityQuestion;
	}
  
}
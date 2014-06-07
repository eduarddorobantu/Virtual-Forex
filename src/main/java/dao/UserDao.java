package dao;

import java.util.List;

import model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired 
	private SessionFactory sessionFactory;
   
	public List<User> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<User> users = session.createQuery("from model.User").list();
		return users;
	}
	
	public User getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User)session.get(User.class, id);
		
		return user;
	}
  
	public User registerUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		
		if (!existsInDB(user.getUsername(), user.getEmail())) {
			session.persist(user);
			return user;
		}
		else
			return null;			
	}
	
	private boolean existsInDB(String username, String email) {
		boolean exist = false;
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "from model.User usr WHERE usr.username = " + username + " or usr.email = " + email;
		
		List<User> users = session.createQuery(hql).list();
		if (users == null)
			return false;
		
		return true;
	}
}
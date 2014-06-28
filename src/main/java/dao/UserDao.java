package dao;

import java.util.List;

import model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class UserDao {
	
	@Autowired 
	private SessionFactory sessionFactory;
   
	public List<User> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<User> users = session.createQuery("from User").list();
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
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User usr WHERE usr.username = :username or usr.email = :email";
		Query q = session.createQuery(hql);
		q.setParameter("username", username);
		q.setParameter("email", email);
		
		List<User> users = q.list();
		if (users.size() == 0)
			return false;
		
		return true;
	}
	
	public User loginUser(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User usr WHERE usr.username = :username and usr.password = :password";
		Query q = session.createQuery(hql);
		q.setParameter("username", username);
		q.setParameter("password", password);
	
		List<User> users = q.list();
		if (users.size() == 0) 
			return null;
		
		return users.get(0);
	}

	public User editUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		
		if (existsInDB(user.getUsername(), user.getEmail())) {
			session.merge(user);
			return user;
		}
		else
			return null;			
	}
	
	public User getByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User usr WHERE usr.username = :username";
		Query q = session.createQuery(hql);
		q.setParameter("username", username);
	
		List<User> users = q.list();
		if (users.size() == 0) 
			return null;
		
		return users.get(0);
	}
}
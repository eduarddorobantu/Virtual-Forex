package dao;

import java.util.List;

import model.Currency;
import model.Message;
import model.Silo;
import model.Transaction;
import model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class TransactionDao {
	
	@Autowired 
	private SessionFactory sessionFactory;
   
	public List<Transaction> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Transaction> transactions = session.createQuery("from Transaction").list();
		
		return transactions;
	}
	
	public List<Transaction> getByUserId(int userId) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "from Transaction tr WHERE tr.user = :userid";
		Query q = session.createQuery(hql);
		q.setParameter("userid", userId);
		List<Transaction> transactions = q.list();
		
		return transactions;
	}
	
	public Transaction getLastTransaction() {
		Session session = sessionFactory.getCurrentSession();
		
		List<Transaction> result = session.createQuery("from Transaction ORDER BY id DESC")
                .setMaxResults(1)
                .list();
		
		return result.get(0);
	}
	
	public Transaction saveTransaction(Transaction transaction) {
		Session session = sessionFactory.getCurrentSession();
		
		session.persist(transaction);
		return getLastTransaction();
	}
  
}
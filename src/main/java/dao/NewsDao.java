package dao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.News;
import model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class NewsDao {
	
	@Autowired 
	private SessionFactory sessionFactory;
   
	public List<News> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<News> news = session.createQuery("from News").list();
		Collections.sort(news, new Comparator<News>() {

			public int compare(News o1, News o2) {
				return o2.getDate().compareTo(o1.getDate());
			}
			
		});
		
		return news;
	}
	
	public News getByTitle(String title) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from News news WHERE news.title = :title";
		Query q = session.createQuery(hql);
		q.setParameter("title", title);
	
		List<News> news = q.list();
		if (news.size() == 0) 
			return null;
		
		return news.get(0);
	}
  
}
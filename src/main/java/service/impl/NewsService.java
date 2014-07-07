package service.impl;

import java.util.List;

import model.News;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.api.INewsService;
import dao.NewsDao;


@Service
public class NewsService implements INewsService {
	@Autowired
	private NewsDao newsDao;
	
	@Transactional
	public List<News> getAll() {
		return newsDao.getAll();
	}

	@Transactional
	public News getByTitle(String title) {
		return newsDao.getByTitle(title);
	}
}

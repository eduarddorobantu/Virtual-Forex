package service.api;

import java.util.List;

import model.News;

public interface INewsService {

	List<News> getAll();
	News getByTitle(String title);
	
}

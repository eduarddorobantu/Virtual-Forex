package service.api;

import java.util.List;

import model.SecurityQuestion;

public interface ISecurityQuestionService {

	List<SecurityQuestion> getAll();
	SecurityQuestion getById(int id);
	
}

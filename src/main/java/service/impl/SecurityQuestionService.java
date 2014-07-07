package service.impl;

import java.util.List;

import model.SecurityQuestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.api.ISecurityQuestionService;
import dao.SecurityQuestionDao;


@Service
public class SecurityQuestionService implements ISecurityQuestionService {
	@Autowired
	private SecurityQuestionDao securityQuestionDao;
	
	@Transactional
	public List<SecurityQuestion> getAll() {
		return securityQuestionDao.getAll();
	}
	
	@Transactional
	public SecurityQuestion getById(int id) {
		return securityQuestionDao.getById(id);
	}

}

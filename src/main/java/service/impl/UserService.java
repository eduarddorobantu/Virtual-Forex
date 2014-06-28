package service.impl;

import java.util.List;


import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.api.IUserService;
import dao.UserDao;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public List<User> getAll() {
		return userDao.getAll();
	}
	
	@Transactional
	public User getById(int id) {
		return userDao.getById(id);
	}
	
	@Transactional
	public User registerUser(User user) {
		return userDao.registerUser(user);
	}
	
	@Transactional
	public User loginUser(String username, String password) {
		return userDao.loginUser(username, password);
	}
	
	@Transactional
	public User editUser(User user) {
		return userDao.editUser(user);
	}
	
	@Transactional
	public User getByUsername(String username) {
		return userDao.getByUsername(username);
	}
}

package service.api;

import java.util.List;

import model.User;

public interface IUserService {

	List<User> getAll();
	User getById(int id);
	User registerUser(User user);
	
}

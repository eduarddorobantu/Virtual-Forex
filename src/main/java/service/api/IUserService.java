package service.api;

import java.util.List;

import model.User;



public interface IUserService {

	List<User> getAll();
	User getById(int id);
	User registerUser(User user);
	User loginUser(String username, String password);
	User editUser(User user);
	User getByUsername(String username);
}

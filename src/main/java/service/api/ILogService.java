package service.api;

import java.util.List;

import model.Log;

public interface ILogService {

	List<Log> getByUserId(int userId);
	List<Log> getAll();
	void saveLog(Log log);
}

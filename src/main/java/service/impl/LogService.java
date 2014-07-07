package service.impl;

import java.util.List;

import model.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.api.ILogService;
import dao.LogDao;


@Service
public class LogService implements ILogService {
	
	@Autowired
	private LogDao logDao;
	
	@Transactional
	public List<Log> getByUserId(int userId) {
		return logDao.getByUserId(userId);
	}

	@Transactional
	public List<Log> getAll() {
		return logDao.getAll();
	}
	
	@Transactional
	public void saveLog(Log log) {
		logDao.saveLog(log);
	}
}

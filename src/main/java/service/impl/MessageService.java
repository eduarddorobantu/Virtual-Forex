package service.impl;

import model.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.api.IMessageService;
import dao.MessageDao;


@Service
public class MessageService implements IMessageService {
	@Autowired
	private MessageDao messageDao;
	
	@Transactional
	public void saveMessage(Message message) {
		messageDao.saveMessage(message);
	}

}

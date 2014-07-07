package service.impl;

import java.util.List;

import model.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.api.ITransactionService;
import dao.TransactionDao;


@Service
public class TransactionService implements ITransactionService {
	
	@Autowired
	private TransactionDao transactionDao;
	
	@Transactional
	public List<Transaction> getAll() {
		return transactionDao.getAll();
	}
	
	@Transactional
	public List<Transaction> getByUserId(int userId) {
		return transactionDao.getByUserId(userId);
	}
	
	@Transactional
	public Transaction saveTransaction(Transaction transaction) {
		return transactionDao.saveTransaction(transaction);
	}
}

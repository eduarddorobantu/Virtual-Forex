package service.api;

import java.util.List;

import model.Transaction;

public interface ITransactionService {

	List<Transaction> getAll();
	List<Transaction> getByUserId(int userId);
	Transaction saveTransaction(Transaction transaction);
}

package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "log")
public class Log implements Serializable {

	private static final long serialVersionUID = -86242352523021987L;
	
	@Id private int id;
	private String operation;
	private int user;
	private int transaction;
	
	
	public Log() {
		super();
	}

	public Log(int id, String operation, int user, int transaction) {
		super();
		this.id = id;
		this.operation = operation;
		this.user = user;
		this.transaction = transaction;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getTransaction() {
		return transaction;
	}

	public void setTransaction(int transaction) {
		this.transaction = transaction;
	}
	
}

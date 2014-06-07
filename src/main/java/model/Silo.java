package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="silo")
public class Silo implements Serializable {
	
	private static final long serialVersionUID = 2514059685942114353L;
	
	@Id private int id;
	private double amount;
	private int currency;
	private int user;
	
	
	public Silo() {
		super();
	}

	public Silo(int id, double amount, int currency, int user) {
		super();
		this.id = id;
		this.amount = amount;
		this.currency = currency;
		this.user = user;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}
		
}

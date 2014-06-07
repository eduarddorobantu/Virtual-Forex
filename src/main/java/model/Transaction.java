package model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 3830870249449611823L;
	
	@Id private int id;
	private double amountFromCurrency;
	private double amountToCurrency;
	private Date date;
	private int fromCurrency;
	private int toCurrency;
	private int user;
	
	
	public Transaction() {
		super();
	}

	public Transaction(int id, double amountFromCurrency,
			double amountToCurrency, Date date, int fromCurrency,
			int toCurrency, int user) {
		super();
		this.id = id;
		this.amountFromCurrency = amountFromCurrency;
		this.amountToCurrency = amountToCurrency;
		this.date = date;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.user = user;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmountFromCurrency() {
		return amountFromCurrency;
	}

	public void setAmountFromCurrency(double amountFromCurrency) {
		this.amountFromCurrency = amountFromCurrency;
	}

	public double getAmountToCurrency() {
		return amountToCurrency;
	}

	public void setAmountToCurrency(double amountToCurrency) {
		this.amountToCurrency = amountToCurrency;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(int fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public int getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(int toCurrency) {
		this.toCurrency = toCurrency;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}
		
}

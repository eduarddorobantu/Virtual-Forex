package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="currency")
public class Currency implements Serializable {

	private static final long serialVersionUID = 3668340234849738182L;
	
	@Id private int id;
	private String code;
	private String name;
	
	
	public Currency() {
		super();
	}

	public Currency(int id, String code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
}

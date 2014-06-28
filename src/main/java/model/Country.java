package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country implements Serializable {

	private static final long serialVersionUID = -3538932163585993723L;
	
	@Id private int id;
	private String name;
	@Column(name="alpha_code")
	private String alphaCode;
	
	
	public Country() {
		super();
	}

	public Country(int id, String name, String alphaCode) {
		super();
		this.id = id;
		this.name = name;
		this.alphaCode = alphaCode;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlphaCode() {
		return alphaCode;
	}

	public void setAlphaCode(String alphaCode) {
		this.alphaCode = alphaCode;
	}
	
	
}

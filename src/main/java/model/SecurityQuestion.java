package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "security_question")
public class SecurityQuestion implements Serializable {

	private static final long serialVersionUID = 8648506992728842974L;
	
	@Id private int id;
	private String question;
	
	
	public SecurityQuestion() {
		super();
	}
	
	public SecurityQuestion(int id, String question) {
		super();
		this.id = id;
		this.question = question;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
}

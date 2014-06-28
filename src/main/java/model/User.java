package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -7530319174301578236L;
	
	@Id @GeneratedValue private int id;
	private String username;
	private String password;
	private String name;
	private String email;
	@JoinColumn(name="country")
	@Column(name="country")
	private int countryId;
	@JoinColumn(name="security_question")
	@Column(name="security_question")
	private int securityQuestionId;
	@Column(name="security_answer")
	private String securityAnswer;
	@JoinColumn(name="role")
	@Column(name="role")
	private int roleId;
	
	
	public User() {
		super();
	}

	public User(int id, String username, String password, String name,
			String email, int countryId, int securityQuestionId,
			String securityAnswer, int roleId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.countryId = countryId;
		this.securityQuestionId = securityQuestionId;
		this.securityAnswer = securityAnswer;
		this.roleId = roleId;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getSecurityQuestionId() {
		return securityQuestionId;
	}

	public void setSecurityQuestionId(int securityQuestionId) {
		this.securityQuestionId = securityQuestionId;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public String toString() {
		return this.id + " " + this.name + " " + this.email + " " + 
				this.username + " " + this.password + " " + 
				this.countryId + " " + this.securityQuestionId + 
				this.securityAnswer;
	}
	
}

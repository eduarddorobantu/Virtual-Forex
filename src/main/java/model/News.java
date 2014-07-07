package model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="news")
public class News implements Serializable {

	private static final long serialVersionUID = -2943022381969804741L;
	
	@Id private int id;
	private String title;
	private String content;
	private Timestamp date;
	
	
	public News() {
		super();
	}

	public News(int id, String title, String content, Timestamp date) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

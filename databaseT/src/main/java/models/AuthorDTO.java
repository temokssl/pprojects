package main.java.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class AuthorDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "login")
	private String login;
	@Column(name = "email")
	private String email;
	
	public AuthorDTO() {
	}
	
	public AuthorDTO(Integer id, String name, String login, String email) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.email = email;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(AuthorDTO.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null)?"<null>":this.id));
		sb.append(',');
		sb.append("name");
		sb.append('=');
		sb.append(((this.name == null)?"<null>":this.name));
		sb.append(',');
		sb.append("login");
		sb.append('=');
		sb.append(((this.login == null)?"<null>":this.login));
		sb.append(',');
		sb.append("email");
		sb.append('=');
		sb.append(((this.email == null)?"<null>":this.email));
		sb.append(',');
		if (sb.charAt((sb.length()- 1)) == ',') {
		sb.setCharAt((sb.length()- 1), ']');
		} else {
		sb.append(']');
		}
		return sb.toString();
	}
}
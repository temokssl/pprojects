package main.java.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class ProjectDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name")
	private String name;

	public ProjectDTO() {
	}
	public ProjectDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ProjectDTO.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null)?"<null>":this.id));
		sb.append(',');
		sb.append("name");
		sb.append('=');
		sb.append(((this.name == null)?"<null>":this.name));
		sb.append(',');
		if (sb.charAt((sb.length()- 1)) == ',') {
		sb.setCharAt((sb.length()- 1), ']');
		} else {
		sb.append(']');
		}
		return sb.toString();
	}
}
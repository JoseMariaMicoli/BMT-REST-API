package com.micoli.backend.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id")
	private Long id;
	
	@Column(name = "task_name")
	private String name;
	
	@Column(name = "task_description")
	private String description;
	
	@Column(name = "task_status")
	private boolean status;
	
	@Column(name = "task_date")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date date;
	
	@ManyToMany
	@JoinTable(name = "users_tasks", 
	joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "task_id"), 
	inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
	private Set<User> users = new HashSet<User>();
	
	public Task() {
		
	}
	
	public Task(Long id, String name, String description, boolean status, Date date, Set<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
		this.date = date;
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	
	
	

}

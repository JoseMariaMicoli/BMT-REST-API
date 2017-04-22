package com.micoli.backend.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "user_name")
	private String name;
	
	@Column(name = "user_phone1")
	private String phone1;
	
	@Column(name = "user_phone2")
	private String phone2;
	
	@Column(name = "user_address")
	private String address;
	
	@Column(name = "user_email")
	private String email;
	
	@Column(name = "user_nick")
	private String nick;
	
	@Column(name = "user_password")
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name = "users_tasks",
		joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "task_id", referencedColumnName = "task_id"))
	private Set<Task> tasks = new HashSet<Task>();
	
	//for JPA!!!
	public User() {
		
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

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getAdress() {
		return address;
	}

	public void setAdress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return nick;
	}

	public void setUserName(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
	

}

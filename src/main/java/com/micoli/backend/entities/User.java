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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
	
	@OneToMany(mappedBy= "user",cascade = CascadeType.ALL)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	private Set<Order> orders = new HashSet<Order>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	private Set<Interview> interviews = new HashSet<Interview>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	private Set<Position> positions = new HashSet<Position>();
	
	//for JPA!!!
	public User() {
		
	}

	public User(Long id, String name, String phone1, String phone2, String address, String email, String nick,
			String password, Set<Task> tasks, Set<Order> orders, Set<Interview> interviews, Set<Position> position) {
		super();
		this.id = id;
		this.name = name;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.address = address;
		this.email = email;
		this.nick = nick;
		this.password = password;
		this.tasks = tasks;
		this.orders = orders;
		this.interviews = interviews;
		this.positions = position;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
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

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<Interview> getInterviews() {
		return interviews;
	}

	public void setInterviews(Set<Interview> interviews) {
		this.interviews = interviews;
	}

	public Set<Position> getPositions() {
		return positions;
	}

	public void setPositions(Set<Position> positions) {
		this.positions = positions;
	}

	
}

package com.micoli.backend.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "candidates")
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "candidate_id")
	private Long id;
	
	@Column(name = "candidate_name")
	private String name;
	
	@Column(name = "candidate_last_name")
	private String lastName;
	
	@Column(name = "candidate_dni")
	private int dni;
	
	@Column(name = "candidate_phone1")
	private String phone1;
	
	@Column(name = "candidate_phone2")
	private String phone2;
	
	@Column(name = "candidate_email")
	private String email;
	
	@Column(name = "candidate_role")
	private String role;
	
	@Column(name = "candidate_seniority")
	private String seniority;
	
	@Column(name = "candidate_status")
	private String status;
	
	@OneToMany(mappedBy = "candidate",cascade = CascadeType.ALL)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	private Set<Interview> interviews =  new HashSet<Interview>();
	
	@ManyToMany
	@JsonBackReference
	@JoinTable(name = "candidates_positions",
		joinColumns = @JoinColumn(name = "candidate_id", referencedColumnName = "candidate_id"),
		inverseJoinColumns = @JoinColumn(name = "position_id", referencedColumnName = "position_id"))
	private Set<Position> positions = new HashSet<Position>();
	
	public Candidate() {
		
	}

	public Candidate(Long id, String name, String lastName, int dni, String phone1, String phone2, String email,
			String role, String seniority, String status, Set<Interview> interviews, Set<Position> positions) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.dni = dni;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.email = email;
		this.role = role;
		this.seniority = seniority;
		this.status = status;
		this.interviews = interviews;
		this.positions = positions;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSeniority() {
		return seniority;
	}

	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

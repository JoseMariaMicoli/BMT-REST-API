package com.micoli.backend.entities;

import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "positions")
public class Position {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "position_id")
	private Long id;
	
	@Column(name = "position_name")
	private String name;
	
	@Column(name = "position_description")
	private String description;
	
	@Column(name = "position_date_start")
	private Date dateStart;
	
	@Column(name = "possition_date_end")
	private Date dateEnd;
	
	@Column(name = "position_status")
	private String status;
	
	@ManyToMany
	@JoinTable(name = "candidates_positions", 
	joinColumns = @JoinColumn(name = "position_id", referencedColumnName = "position_id"), 
	inverseJoinColumns = @JoinColumn(name = "candidate_id", referencedColumnName = "candidate_id"))
	private Set<Candidate> candidates = new HashSet<Candidate>();
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	private Set<Interview> interviews = new HashSet<Interview>();
	
	public Position() {
		
	}

	public Position(Long id, String name, String description, Date dateStart, Date dateEnd, String status,
			Set<Candidate> candidates, User user, Set<Interview> interviews) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.status = status;
		this.candidates = candidates;
		this.user = user;
		this.interviews = interviews;
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

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(Set<Candidate> candidates) {
		this.candidates = candidates;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Interview> getInterviews() {
		return interviews;
	}

	public void setInterviews(Set<Interview> interviews) {
		this.interviews = interviews;
	}
	
	
}

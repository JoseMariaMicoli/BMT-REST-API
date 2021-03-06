package com.micoli.backend.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Long id;
	
	@Column(name = "order_status")
	private String status;
	
	@Column(name = "order_date")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date date;
	
	@Column(name = "order_delivery_date")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date deliveryDate;
	
	@Column(name = "order_total")
	private double total;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToMany
	@JoinTable(name = "products_orders", 
	joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "order_id"), 
	inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "product_id"))
	private Set<Product> products = new HashSet<Product>();
	
	public Order() {
		
	}

	public Order(Long id, String status, Date date, Date deliveryDate, double total, Customer customer, User user,
			Set<Product> products) {
		super();
		this.id = id;
		this.status = status;
		this.date = date;
		this.deliveryDate = deliveryDate;
		this.total = total;
		this.customer = customer;
		this.user = user;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	

}

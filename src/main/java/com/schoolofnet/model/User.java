package com.schoolofnet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="username")
	private String username;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name= "createDate")
	private Date createDate;

	@Column
	private Address address;
	
	@Column
	@ElementCollection
	private List<Options> options;
	
	@Column
	@ElementCollection
	private List<Computer> computers;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@OneToOne(mappedBy = "user")
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@OneToMany(mappedBy = "options")
	public List<Options> getOptions() {
		return options;
	}
	
	public void setOptions(List<Options> options) {
		this.options = options;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "computers")
	public List<Computer> getComputers() {
		return computers;
	}
	
	public void setComputers(List<Computer> computers) {
		this.computers = computers;
	}
		
	@Override
	public String toString() {
		return "User [id=]" + id + ", username = " + username + ", name = " + name + ", lastname = " + lastname + ", createDate = " + createDate + "]";
	}
}

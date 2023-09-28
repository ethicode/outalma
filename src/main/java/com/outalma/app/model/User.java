package com.outalma.app.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=true)
	private String name;
	
	@Column(name="email", length=50, nullable=false)
	private String email;
	
	@Column(name="password", length=30, nullable=false)
	private String password;
	
	@Column(length=50, nullable=true)
	private String phone;
	
	@Column(nullable=true)
	private boolean isenabled = false;
	
	@Column(nullable=true)
	private boolean isBlocked = false;
	
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Address address;
	
	@OneToMany(mappedBy="user")
    private Set<Post> ratings = new HashSet<>();
	
	@Column(name="add", nullable=true)
	private LocalDateTime add;
	
	@Column(name="update", nullable=true)
	private LocalDateTime update;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isIsenabled() {
		return isenabled;
	}

	public void setIsenabled(boolean isenabled) {
		this.isenabled = isenabled;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public LocalDateTime getAdd() {
		return add;
	}

	public void setAdd(LocalDateTime add) {
		this.add = add;
	}

	public LocalDateTime getUpdate() {
		return update;
	}

	public void setUpdate(LocalDateTime update) {
		this.update = update;
	}
	
	

}

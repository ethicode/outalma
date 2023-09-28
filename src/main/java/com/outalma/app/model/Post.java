package com.outalma.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private String description;
	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
	private User user;
	
	@Column(nullable=true)
	private boolean isenabled = false;
	
	@Column(nullable=true)
	private boolean isBlocked = false;
	
	@OneToOne(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Address address;
	
	@Column(name="add", nullable=true)
	private LocalDateTime add;
	
	@Column(name="update", nullable=true)
	private LocalDateTime update;

}

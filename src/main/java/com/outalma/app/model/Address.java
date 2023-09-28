package com.outalma.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = true)
	private String street;
	
	@Column(nullable = true)
    private String city;
	
	@Column(nullable = true)
    private String zipCode;
	
	@Column(nullable = true)
    private String longitude;
	
	@Column(nullable = true)
    private String latitude;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

}

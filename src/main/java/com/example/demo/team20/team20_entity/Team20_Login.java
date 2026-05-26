package com.example.demo.team20.team20_entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name="`team20_login_tbl`")
@Data
public class Team20_Login {
	@Id
	@Column(name = "USERID")
	private String userid;
	private String password;
	
}
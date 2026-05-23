package com.example.demo.team20_entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name="login_tbl")
@Data
public class Team20_Login {
	@Id
	private String userid;
	private String password;
	
}
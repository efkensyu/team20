package com.example.demo.team20.team20_entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name="`team20_hobby_tb`l")
@Data
public class Team20_Hobby {
	@Id
	@Column(name = "HOBBYCODE")
	private String hobbyCd; 
	@Column(name = "JANRU")
	private String janru; 
	@Column(name = "HOBBY")
	private String hobby; 
	
}		
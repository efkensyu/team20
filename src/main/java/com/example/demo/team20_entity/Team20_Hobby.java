package com.example.demo.team20_entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name="`team20_hobby_tb`l")
@Data
public class Team20_Hobby {
	@Id
	private String hobbyCd; 
	private String janru; 
	private String hobby; 
	
}		
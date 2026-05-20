package com.example.demo.team20_entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name="shain_tbl")
@Data
public class Team20_Shain {
	@Id
	private String shainCd; 
	private String loginPass; 
	private String shainNm; 
	private String genre;
	private String hobby;
	private String hobbyRanking;
	private String introduction;
}		
package com.example.demo.team20_entity;

import jakarta.persistence.Column;
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
	private String shainNm;
	private String rank1;
	private String rank2;
	private String rank3;
	private String job;
	@Column(name="intro")
	private String intro;
	
//	public String getLoginPass() {
//		return loginPass;
//	}
}
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
	private String shainNm;
	private String loginPass;
	private String rank1;
	private String rank2;
	private String rank3;
	private String job;
	private String intro;
	
	public String getLoginPass() {
		return loginPass;
	}
}
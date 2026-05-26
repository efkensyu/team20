package com.example.demo.team20.team20_entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name="team20_shain_tbl")

@Data
public class Team20_Shain {
	@Id
	@Column(name="shaincd")
	private String shainCd;
	@Column(name="shainnm")
	private String shainNm;
	@Column(name="rank1")   
	private String rank1;
	@Column(name="rank2")
	private String rank2;
	@Column(name="rank3")
	private String rank3;
	@Column(name="job")
	private String job;
	@Column(name="intro")
	private String intro;
	
//	public String getLoginPass() {
//		return loginPass;
//	}
}
package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "shain_tbl")
@Data
public class Shain {
	@Id
	private String shainCd;	//
	private String shainNm;//
	private String bumonCd;
	private String kanriCd;
	private String jyusho;
	private String denwa;
	private String seibetsu;
	private String nyushaDate;
	private Integer nenrei;//
	private String yakushokuCd;
	private Integer kyuryo;
	private String jyochoCd;
	private String taishokuDate;
}		

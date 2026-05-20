package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity//エンティティクラスであると宣言
@Table(name = "bumon_tbl")//対応させるテーブル名を指定
@Data
public class Bumon {	
	@Id //プライマリーキーを指定、主キー
	private String bumonCd;
	private String bumonNm;

}		

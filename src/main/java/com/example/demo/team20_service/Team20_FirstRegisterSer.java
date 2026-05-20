package com.example.demo.team20_service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team20_entity.Team20_Shain;

import lombok.RequiredArgsConstructor;
import team20_repogitory.Team20_FirstRegisterRepogitory;

@Service
@RequiredArgsConstructor
public class Team20_FirstRegisterSer {
	private final Team20_FirstRegisterRepogitory repository;
	
	public List<Team20_Shain> findByShainCd(String shainCd) {
		return repository.findByShainCd(shainCd);
	}
	
	public List<Team20_Shain> regist(String shainNm, String shainCd, String loginPass) {
		return repository.regist(shainNm, shainCd, loginPass);
	}
}

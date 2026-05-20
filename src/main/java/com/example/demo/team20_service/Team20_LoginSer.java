package com.example.demo.team20_service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team20_entity.Team20_Shain;

import lombok.RequiredArgsConstructor;
import team20_repogitory.Team20_LoginRepogitory;

@Service
@RequiredArgsConstructor
public class Team20_LoginSer {
	private final Team20_LoginRepogitory repository;
	
	public List<Team20_Shain> findByName(String shainCd) {
		return repository.findByName(shainCd);
	}
}

package com.example.demo.team20_service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team20_entity.Team20_Shain;
import com.example.demo.team20_repository.Team20_LoginRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team20_LoginSer {
	private final Team20_LoginRepository repository;
	
	public List<Team20_Shain> findByShainCd(String shainCd) {
		return repository.findByShainCd(shainCd);
	}
}

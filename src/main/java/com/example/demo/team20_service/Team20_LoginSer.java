package com.example.demo.team20_service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team20_entity.Team20_Shain;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team20_LoginSer {
	private final LoginRepository repository;
	
	public List<Team20_Shain> findByNameAndPass(String loginName, String loginPass) {
		return repository.findByNameAndPass();
	}
}

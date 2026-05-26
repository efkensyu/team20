package com.example.demo.team20.team20_service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team20.team20_entity.Team20_Login;
import com.example.demo.team20.team20_repository.Team20_LoginRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Team20_LoginSer {
	private Team20_LoginRepository repository;
	
	public Team20_LoginSer(Team20_LoginRepository repository) {
		this.repository = repository;
	}
	public List<Team20_Login> find(String userid) {
		log.info("[Service開始] ログインユーザー検索を実行します。 検索対象ID: {}", userid);
		return repository.find(userid);
		
	}
}

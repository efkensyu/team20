package com.example.demo.team20_service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team20_entity.Team20_Login;
import com.example.demo.team20_repository.Team20_LoginRepository;

@Service
public class Team20_LoginSer {
	private Team20_LoginRepository repository;
	
	public Team20_LoginSer(Team20_LoginRepository repository) {
		this.repository = repository;
	}
	public List<Team20_Login> find(String userid) {
		return repository.find(userid);
	}
}

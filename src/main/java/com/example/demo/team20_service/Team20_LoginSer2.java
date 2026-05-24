package com.example.demo.team20_service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team20_entity.Team20_Login;
import com.example.demo.team20_repository.Team20_LoginRepository2;

@Service
public class Team20_LoginSer2 {
	private Team20_LoginRepository2 repository;
	
	public Team20_LoginSer2(Team20_LoginRepository2 repository) {
		this.repository = repository;
	}
	
//	public Boolean isPass(Team20_Login login) {
//		List<Team20_Login> result = repository.find(login.getUserid(), login.getPassword());
//		if(result.size() > 0) {
//			return true;
//		}
//		return false;
//	}
	
	public List<Team20_Login> find(String userid) {
		return repository.find(userid);
	}
}

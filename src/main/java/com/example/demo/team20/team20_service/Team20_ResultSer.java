package com.example.demo.team20.team20_service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.team20.team20_entity.Team20_Shain;
import com.example.demo.team20.team20_repository.Team20_ResultRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team20_ResultSer {
	private final Team20_ResultRepository repository;
	
	public ArrayList<Team20_Shain> ChangeHobbyList(ArrayList<Team20_Shain> resultList) {
		if(resultList!=null) {
			for(Team20_Shain s:resultList) {
				s.setRank1(getHobbyName(s.getRank1()));	
				s.setRank2(getHobbyName(s.getRank2()));
				s.setRank3(getHobbyName(s.getRank3()));
				}
		}
		return resultList;
		}
	public String getHobbyName(String code) {
		if(code == null || code.trim().isEmpty() ||"null".equals(code)) {
			return"未設定";
		}
		if(code.contains("/")) {
			return code;
		}
		String fullName=repository.findHobbyName(code);
			return fullName!=null ?fullName:"未設定";
		}
	}


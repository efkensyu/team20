package com.example.demo.team20.team20_service;

import org.springframework.stereotype.Service;

import com.example.demo.team20.team20_entity.Team20_Shain;
import com.example.demo.team20.team20_repository.Team20_DetailsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team20_DetailsService {
	private final Team20_DetailsRepository repository;
	
	public Team20_Shain findPerson(String shainCd) {
		Team20_Shain shain=repository.findById(shainCd).orElse(null);
		if(shain !=null) {
			String h1= repository.findHobbyname(shain.getRank1());
			String h2= repository.findHobbyname(shain.getRank2());
			String h3= repository.findHobbyname(shain.getRank3());
			shain.setRank1(h1);
			shain.setRank2(h2);
			shain.setRank3(h3);
		}
		return shain;
		}
	
}

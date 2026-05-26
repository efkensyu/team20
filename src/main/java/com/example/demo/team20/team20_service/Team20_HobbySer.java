package com.example.demo.team20.team20_service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team20.team20_entity.Team20_Hobby;
import com.example.demo.team20.team20_repository.Team20_HobbyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team20_HobbySer {
	private final Team20_HobbyRepository repository;

	//ジャンルからhobbyリストをかえす
	public List<Team20_Hobby>getHobbiesByJanru(String janru) {
        
		return repository.findByJanru(janru);
	}
	
	public List<Team20_Hobby> getAllHobbies() {
	    return repository.findAll();
	}
	
}

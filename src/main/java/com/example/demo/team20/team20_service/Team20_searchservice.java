package com.example.demo.team20.team20_service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team20.team20_entity.Team20_Shain;
import com.example.demo.team20.team20_repository.Team20_searchserviceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team20_searchservice {
	private final Team20_searchserviceRepository repository;
	public List<Team20_Shain> findmatch(String name,String janru,String hobby,String job){
		return repository.findmatch(name, janru, hobby,job);
		
	}
}

package com.example.demo.team20_service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team20_entity.Team20_Shain;

import lombok.RequiredArgsConstructor;
import team20_repogitory.Team20_searchserviceRepository;

@Service
@RequiredArgsConstructor
public class Team20_searchservice {
	private final Team20_searchserviceRepository repository;
	public List<Team20_Shain> findmatch(String name,String genre,String hobby){
		return repository.findmatch(name, genre, hobby);
		
	}

}

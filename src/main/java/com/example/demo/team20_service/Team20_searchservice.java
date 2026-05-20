package com.example.demo.team20_service;

<<<<<<< HEAD
/*@Service
=======
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team20_entity.Team20_Shain;
import com.example.demo.team20_repository.Team20_searchserviceRepository;

import lombok.RequiredArgsConstructor;

@Service
>>>>>>> 86b392fae51fcdc7298064cf303535e5340d88dc
@RequiredArgsConstructor
public class Team20_searchservice {
	private final Team20_searchserviceRepository repository;
	public List<Team20_Shain> findmatch(String name,String genre,String hobby){
		return repository.findmatch(name, genre, hobby);
		
	}

}*/

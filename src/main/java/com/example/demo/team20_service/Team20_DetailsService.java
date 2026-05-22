package com.example.demo.team20_service;

import org.springframework.stereotype.Service;

import com.example.demo.team20_entity.Team20_Shain;
import com.example.demo.team20_repository.Team20_DetailsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team20_DetailsService {
	private final Team20_DetailsRepository repository;
	
	public Team20_Shain findPerson(String shainCd) {
		return repository.findPerson(shainCd);
		}
	
}

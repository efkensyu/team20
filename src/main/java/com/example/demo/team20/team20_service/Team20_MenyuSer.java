package com.example.demo.team20.team20_service;

import org.springframework.stereotype.Service;

import com.example.demo.team20.team20_repository.Team20_MenyuRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team20_MenyuSer {
	private final Team20_MenyuRepository repository;
	public String find(String userid) {
		return repository.find(userid);
	}
}

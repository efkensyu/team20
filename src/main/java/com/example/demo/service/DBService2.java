package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Bumon;
import com.example.demo.repositories.BumonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DBService2 { //複数人で行うための準備
	private final BumonRepository repository;
	
	public List<Bumon> findAll(){
		return repository.findAll();
	}
	
}

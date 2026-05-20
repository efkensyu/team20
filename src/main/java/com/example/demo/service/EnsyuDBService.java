package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Shain;
import com.example.demo.repositories.ShainRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnsyuDBService {
	private final ShainRepository repository;

	public List<Shain> findByShainCd(String shainNm) {
		//return repository.findByBumonCd(code);
		//return repository.findByShainNmContaining(shainNm);
		return repository.findByShainNmContainingOrderByNenreiAsc(shainNm);
	}
	public List<Shain> findByShainCd0(String shainNm) {
		
		return repository.findAllByOrderByShainCdAsc();
	}
	

}

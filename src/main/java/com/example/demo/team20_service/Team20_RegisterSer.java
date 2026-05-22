package com.example.demo.team20_service;

import org.springframework.stereotype.Service;

import com.example.demo.team20_controller.RegForm;
import com.example.demo.team20_repository.Team20_registerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team20_RegisterSer {
	private final Team20_registerRepository repository;
	
	public void Proupdate(RegForm regForm) {

		repository.update(
				regForm.getCode(),// shainCd
				regForm.getHobby(),// rank1
				regForm.getHobby2(),// rank2
				regForm.getHobby3(),// rank3
				regForm.getJob(),// job
				regForm.getIntro()// introduction
				);
	}
}

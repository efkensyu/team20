package com.example.demo.team20_service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team20_controller.Team20_RegForm;
import com.example.demo.team20_entity.Team20_Hobby;
import com.example.demo.team20_repository.Team20_registerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team20_RegisterSer {
	private final Team20_registerRepository repository;
	private String rank1, rank2, rank3;

	public List<Team20_Hobby> findByHobby(Team20_RegForm regForm) {
		rank1 = regForm.getHobby();
		rank2 = regForm.getHobby2();
		rank3 = regForm.getHobby3();

		return repository.findByHobbyEquals(rank1, rank2, rank3);
	}

	public void Proupdate(Team20_RegForm regForm) {

		repository.update(
				regForm.getCode(), // shainCd
				this.rank1, // rank1
				this.rank2, // rank2
				this.rank3, // rank3
				regForm.getJob(), // job
				regForm.getIntro()// intro
		);
	}
}

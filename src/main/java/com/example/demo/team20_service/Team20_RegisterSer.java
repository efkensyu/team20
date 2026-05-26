package com.example.demo.team20_service;

import org.springframework.stereotype.Service;

import com.example.demo.team20_controller.Team20_RegForm;
import com.example.demo.team20_repository.Team20_RegisterRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team20_RegisterSer {
	private final Team20_RegisterRepository repository;
//	private String rank1, rank2, rank3;

//	public List<Team20_Hobby> findByHobby(Team20_Shain team20_Shain) {
//		rank1 = team20_Shain.getHobby();
//		rank2 = team20_Shain.getHobby2();
//		rank3 = team20_Shain.getHobby3();
//
//		return repository.findByHobbyEquals(rank1, rank2, rank3);
//	}

	public void Proupdate(Team20_RegForm regForm) {

		repository.update(
				regForm.getCode(), // shainCd
				regForm.getHobby(),  // rank1 ← hobbyCd
	            regForm.getHobby2(), // rank2 ← hobbyCd
	            regForm.getHobby3(), // rank3 ← hobbyCd
				regForm.getJob(), // job
				regForm.getIntro()// intro
		);
	}
}

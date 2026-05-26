package com.example.demo.team20.team20_service;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.team20.team20_controller.Team20_RegForm;
import com.example.demo.team20.team20_repository.Team20_RegisterRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class Team20_RegisterSer {
	private final Team20_RegisterRepository repository;

	@Transactional
	public void Proupdate(Team20_RegForm regForm) {
		
		log.info("[Service開始] 社員情報の更新処理を実行。対象社員コード: {}", regForm.getCode());
//		log.info("  パラメータ - rank1: {}, rank2: {}, rank3: {}, job: {}", 
//                regForm.getRank1(), regForm.getRank2(), regForm.getRank3(), regForm.getJob());
		
		try {
		int updatedRows = repository.update(
				regForm.getCode(), // shainCd
				regForm.getHobby(),  // rank1 ← hobbyCd
	            regForm.getHobby2(), // rank2 ← hobbyCd
	            regForm.getHobby3(), // rank3 ← hobbyCd
				regForm.getJob(), // job
				regForm.getIntro()// intro
		);
		
		log.info("[Service成功] 社員情報の更新が完了しました。更新件数: {}件", updatedRows);
		}catch(Exception e) {
			log.error("[Service失敗] 社員情報の更新中にエラーが発生しました。理由: {}", e.getMessage(), e);
			throw e; //コントローラーに例外を投げだす
		}
	}
}

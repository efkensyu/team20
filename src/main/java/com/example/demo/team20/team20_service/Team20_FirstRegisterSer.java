package com.example.demo.team20.team20_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.team20.team20_entity.Team20_Login;
import com.example.demo.team20.team20_entity.Team20_Shain;
import com.example.demo.team20.team20_repository.Team20_FirstRegisterRepository;
import com.example.demo.team20.team20_repository.Team20_LoginRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class Team20_FirstRegisterSer {
	@Autowired
	private Team20_FirstRegisterRepository firstRepository;
	private Team20_LoginRepository loginRepository;
	
	public Team20_FirstRegisterSer(Team20_FirstRegisterRepository firstRepository, Team20_LoginRepository loginRepository) {
		this.firstRepository = firstRepository;
		this.loginRepository = loginRepository;
	}
	public List<Team20_Login> find(String shainCd) {
		log.info("[FirstRegisterSer] 重複チェックのためのユーザー検索を実行。 ID: {}", shainCd);
		return loginRepository.find2(shainCd);
	}
	
	public void registLogin(String userid, String password) {
		log.info("[FirstRegisterSer] ログインマスタ(team20_login_tbl)へのインサートを開始。 ID: {}", userid);
		
		Team20_Login login = new Team20_Login();
        login.setUserid(userid);
        login.setPassword(password);

        // 2. Spring標準のsaveメソッドで安全にINSERTを実行
        loginRepository.save(login);
        
        log.info("[FirstRegisterSer成功] ログインマスタへの登録が完了しました。");
	}
	
	public void registShain(String shainCd, String shainNm) {
		log.info("[FirstRegisterSer] 社員マスタ(team20_shain_tbl)へのインサートを開始。 社員コード: {}", shainCd);
		
		Team20_Shain shain = new Team20_Shain();
        shain.setShainCd(shainCd);
        shain.setShainNm(shainNm);

        // 2. Spring標準のsaveメソッドで保存する（SQLは自動生成されます）
        firstRepository.save(shain);
	}
}

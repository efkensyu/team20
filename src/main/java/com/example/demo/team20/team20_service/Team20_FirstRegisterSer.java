package com.example.demo.team20.team20_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.team20.team20_entity.Team20_Login;
import com.example.demo.team20.team20_entity.Team20_Shain;
import com.example.demo.team20.team20_repository.Team20_FirstRegisterRepository;
import com.example.demo.team20.team20_repository.Team20_LoginRepository;

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
		return loginRepository.find2(shainCd);
	}
	
	public void registLogin(String userid, String password) {
		Team20_Login login = new Team20_Login();
        login.setUserid(userid);
        login.setPassword(password);

        // 2. Spring標準のsaveメソッドで安全にINSERTを実行
        loginRepository.save(login);
	}
	
	public void registShain(String shainCd, String shainNm) {
		Team20_Shain shain = new Team20_Shain();
        shain.setShainCd(shainCd);
        shain.setShainNm(shainNm);

        // 2. Spring標準のsaveメソッドで保存する（SQLは自動生成されます）
        firstRepository.save(shain);
	}
}

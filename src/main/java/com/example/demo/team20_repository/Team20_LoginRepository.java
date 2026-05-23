package com.example.demo.team20_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team20_entity.Team20_Login;

@Repository
public interface Team20_LoginRepository extends JpaRepository<Team20_Login, String> {
public  List<Team20_Login> findByUseridAndPassword(String Userid, String Password);

//public interface Team20_LoginRepository extends JpaRepository<Team20_Shain, String> {
//	public  List<Team20_Shain> findByShainCd(String shainCd);
}

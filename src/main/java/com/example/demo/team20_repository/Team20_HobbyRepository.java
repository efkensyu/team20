package com.example.demo.team20_repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team20_entity.Team20_Hobby;

@Repository
public interface Team20_HobbyRepository extends JpaRepository<Team20_Hobby, String> {
	//ジャンルからhobbyリストを取得
	
	@Query("select h from Team20_Hobby h where h.janru = :janru")
	List<Team20_Hobby>findByJanru(@Param("janru")String janru);
}
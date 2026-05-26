package com.example.demo.team20.team20_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team20.team20_entity.Team20_Shain;

@Repository
public interface Team20_MenyuRepository extends JpaRepository<Team20_Shain, String> {
	@Query(value="select shainNm from team20_shain_tbl where SHAINCD = :userid", nativeQuery = true)
	public String find(@Param("userid") String userid);
}
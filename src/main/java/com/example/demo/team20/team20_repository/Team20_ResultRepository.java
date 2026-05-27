package com.example.demo.team20.team20_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team20.team20_entity.Team20_Shain;

@Repository
public interface Team20_ResultRepository extends JpaRepository<Team20_Shain, String> {

	@Query(value="select concat(h.janru, '/', h.hobby) from team20_hobby_tbl h where h.hobbycode = :code", nativeQuery=true)
	public String findHobbyName(@Param("code") String code);
}
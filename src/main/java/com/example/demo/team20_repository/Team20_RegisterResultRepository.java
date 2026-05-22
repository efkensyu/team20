package com.example.demo.team20_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team20_entity.Team20_Shain;

@Repository
public interface Team20_RegisterResultRepository extends JpaRepository<Team20_Shain, String> {

	@Query("SELECT s FROM Team20_Shain s WHERE s.shainCd <> :shainCd")
    List<Team20_Shain> findAllExcludeSelf(@Param("shainCd") String shainCd);
}
package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Bumon;

@Repository
public interface BumonRepository extends JpaRepository<Bumon, String>{
	public List<Bumon> findByBumonCd(String code);
	
	@Query(value = "select * from bumon_tbl where bumon_cd = :code", nativeQuery = true)
	public List<Bumon> findBumonCd(@Param("code")String code);
}

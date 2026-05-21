package com.example.demo.team20_repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.team20_entity.Team20_Shain;

@Repository
public interface Team20_searchserviceRepository extends JpaRepository<Team20_Shain,String>{
	@Query(value="select * from shain_tbl "+
				" where (:name is null or shain_nm like %:name%)" +
				"and (:janru is null or janru = :janru)" +
				"and (:hobby is null or hobby like %:hobby%)",nativeQuery=true)
	public List<Team20_Shain> findmatch(String name,String genre,String hobby);
}
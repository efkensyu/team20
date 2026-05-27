package com.example.demo.team20.team20_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team20.team20_entity.Team20_Shain;

@Repository
public interface Team20_DetailsRepository extends JpaRepository<Team20_Shain, String> {

	
	@Query(value="SELECT CONCAT(JANRU, '/', HOBBY) FROM team20_hobby_tbl WHERE upper(trim(HOBBYCODE)) =upper(trim( :hobbyCode))", nativeQuery=true)	
	public String findHobbyname(@Param("hobbyCode") String hobbyCode);
		}


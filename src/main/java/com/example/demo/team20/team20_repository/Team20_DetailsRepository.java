package com.example.demo.team20.team20_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team20.team20_entity.Team20_Shain;

@Repository
public interface Team20_DetailsRepository extends JpaRepository<Team20_Shain, String> {

	@Query(value="select shaincd,shainnm,rank1,rank2,rank3,job,intro from shain_tbl where shaincd = :shainCd", nativeQuery=true)
		public Team20_Shain findPerson(@Param("shainCd")String shainCd);
	@Query(value="select janru || '/' || hobby from hobby_tbl where hobbycode=:hobbyCode",nativeQuery=true)	
	public String findHobbyname(@Param("hobbycode") String hobbyCode);

		}


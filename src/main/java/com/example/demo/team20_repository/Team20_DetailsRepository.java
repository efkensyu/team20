package com.example.demo.team20_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team20_entity.Team20_Shain;

@Repository
public interface Team20_DetailsRepository extends JpaRepository<Team20_Shain, String> {
	@Query(value="SELECT "
			+ "    shain_cd,"
			+ "    shain_nm,"
			+ "    (SELECT janru||'/'|| hobby FROM hobby_tbl WHERE hobby_cd = rank1) AS rank1,"
			+ "    (SELECT janru||'/'|| hobby FROM hobby_tbl WHERE hobby_cd = rank2) AS rank2,"
			+ "    (SELECT janru||'/'|| hobby FROM hobby_tbl WHERE hobby_cd = rank3) AS rank3,"
			+ "    job,"
			+ "    intro"
			+ " FROM shain_tbl WHERE shain_cd = :code",nativeQuery=true)
		public Team20_Shain findPerson(@Param("code")String shain_cd);
			
		}


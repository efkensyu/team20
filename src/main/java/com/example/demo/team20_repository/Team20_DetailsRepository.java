package com.example.demo.team20_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team20_entity.Team20_Shain;

@Repository
public interface Team20_DetailsRepository extends JpaRepository<Team20_Shain, String> {
	@Query(value="SELECT "
			+ "  s.shaincd,"
			+ "    s.shainnm,"
			+ "    (SELECT h.janru||'/'|| h.hobby FROM hobby_tbl h WHERE h.hobbycode = s.rank1) AS rank1,"
			+ "    (SELECT h.janru||'/'|| h.hobby FROM hobby_tbl h WHERE h.hobbycode = s.rank2) AS rank2,"
			+ "    (SELECT h.janru||'/'|| h.hobby FROM hobby_tbl h WHERE h.hobbycode = s.rank3) AS rank3,"
			+ "    s.job,"
			+ "    s.intro"
			+ " FROM shain_tbl s WHERE shaincd = :code",nativeQuery=true)
		public Team20_Shain findPerson(@Param("code")String shaincd);
			
		}


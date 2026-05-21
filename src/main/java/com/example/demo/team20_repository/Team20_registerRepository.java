package com.example.demo.team20_repository;

import jakarta.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team20_entity.Team20_Shain;

@Repository
public interface Team20_registerRepository extends JpaRepository<Team20_Shain, String> {

	@Modifying
	@Transactional
	@Query(value = "update shain_tbl set rank1=:rank1, rank2=:rank2, rank3=:rank3, job=:job, introduction=:introduction where shainCd=:shainCd", nativeQuery = true)
	public int update(@Param("shainCd") String shainCd, @Param("rank1") String rank1,@Param("rank2") String rank2,@Param("rank3") String rank3,
			@Param("job") String job,@Param("introduction") String introduction);
//	@Query(value = "update shain_tbl set rank1=:rank1, rank2=:rank2, rank3=:rank3, job=:job, introduction=:introduction where shainCd=:shainCd", nativeQuery = true)
//	public List<Team20_Shain> update(@Param("shainCd") String shainCd, @Param("rank1") String rank1,@Param("rank2") String rank2,@Param("rank3") String rank3,
//			@Param("job") String job,@Param("introduction") String introduction);
}
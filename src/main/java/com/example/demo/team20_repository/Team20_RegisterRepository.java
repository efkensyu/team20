package com.example.demo.team20_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.team20_entity.Team20_Hobby;
import com.example.demo.team20_entity.Team20_Shain;

@Repository
public interface Team20_RegisterRepository extends JpaRepository<Team20_Shain, String> {

	
	@Query(value="select hobby_cd from team20_hobby_tbl where hobby=:rank1 and hobby=:rank2 and hobby=:rank3",nativeQuery = true)
	public List<Team20_Hobby> findByHobbyEquals(@Param("hobby")String rank1,@Param("hobby")String rank2,@Param("hobby")String rank3);
	
	
	@Transactional
	@Modifying
	@Query(value = "update shain_tbl set rank1=:rank1, rank2=:rank2, rank3=:rank3, job=:job, intro=:intro where shainCd=:shainCd", nativeQuery = true)
	public int update(@Param("shainCd") String shainCd, @Param("rank1") String rank1, @Param("rank2") String rank2,
			@Param("rank3") String rank3,
			@Param("job") String job, @Param("intro") String intro);
	
}


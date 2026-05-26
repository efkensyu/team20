package com.example.demo.team20_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team20_entity.Team20_Hobby;
import com.example.demo.team20_entity.Team20_Shain;

@Repository
public interface Team20_RegisterRepository extends JpaRepository<Team20_Shain, String> {

	
	@Query(value="select hobby_cd from team20_hobby_tbl where hobby=:rank1 and hobby=:rank2 and hobby=:rank3",nativeQuery = true)
	public List<Team20_Hobby> findByHobbyEquals(@Param("hobby")String rank1,@Param("hobby")String rank2,@Param("hobby")String rank3);

}

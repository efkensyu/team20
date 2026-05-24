package com.example.demo.team20_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team20_entity.Team20_Login;

@Repository
public interface Team20_LoginRepository2 extends JpaRepository<Team20_Login, String> {
	@Query(value="select * from login_tbl where USERID = :userid", nativeQuery = true)
	public List<Team20_Login> find(@Param("userid") String userid);
}

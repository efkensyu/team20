package com.example.demo.team20.team20_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team20.team20_entity.Team20_Login;

@Repository
public interface Team20_LoginRepository extends JpaRepository<Team20_Login, String> {
	@Query(value="select * from team20_login_tbl where USERID = :userid", nativeQuery = true)
	public List<Team20_Login> find(@Param("userid") String userid);
	@Query(value="select * from team20_login_tbl where USERID = :userid", nativeQuery = true)
	public List<Team20_Login> find2(@Param("userid") String shainCd);
//	@Modifying
//	@Transactional
//	@Query(value="insert into login_tbl (userid, password) values (:shainCd, :loginPass)", nativeQuery = true)
//	public List<Team20_Login> registLogin(@Param("loginPass")String loginPass, @Param("shainCd")String shainCd);
}

package com.example.demo.team20_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team20_entity.Team20_Shain;

@Repository
public interface Team20_FirstRegisterRepository extends JpaRepository<Team20_Shain, String> {
//	@Modifying
//	@Transactional
//	@Query(value="insert into shain_tbl (shainCd, shainNm) values (:shainCd, :shainNm)", nativeQuery = true)
//	public List<Team20_Shain> registShain(@Param("shainNm")String shainNm, @Param("shainCd")String shainCd);
}

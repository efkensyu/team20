package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Shain;

@Repository
public interface ShainRepository extends JpaRepository<Shain, String> {

	//public List<Shain> findByShainNmContaining(String shainNm);
	public List<Shain> findByShainNmContainingOrderByNenreiAsc(String shainNm);

	public List<Shain> findAllByOrderByShainCdAsc();

//	@Query(value = "select * from shain_tbl order by shain_cd", nativeQuery = true)
//	public List<Shain> findShainCd();
}

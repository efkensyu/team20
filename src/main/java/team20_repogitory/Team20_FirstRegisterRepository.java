package team20_repogitory;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team20_entity.Team20_Shain;

@Repository
public interface Team20_FirstRegisterRepository extends JpaRepository<Team20_Shain, String> {
	@Query(value="select loginPass from shain_tbl where shainCd = :shainCd" , nativeQuery = true)
	public List<Team20_Shain> findByShainCd(@Param("shainCd")String shainCd);
	
	@Modifying
	@Transactional
	@Query(value="insert into shain_tbl (shainCd, loginPass, shainNm) values (:shainCd, :loginPass, :shainNm)", nativeQuery = true)
	public List<Team20_Shain> regist(@Param("shainNm")String shainNm, @Param("shainCd")String shainCd, @Param("loginPass")String loginPass);
}

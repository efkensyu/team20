package team20_repogitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team20_entity.Team20_Shain;

@Repository
public interface Team20_LoginRepogitory extends JpaRepository<Team20_Shain, String> {
	@Query(value="select loginPass from shain_tbl where shainCd = :shainCd" , nativeQuery = true)
	public List<Team20_Shain> findByShainCd(@Param("shainCd")String shainCd);
}


package com.example.demo.team20_repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team20_entity.Team20_Shain;

@Repository
public interface Team20_searchserviceRepository extends JpaRepository<Team20_Shain,String>{
	@Query(value="select * from shain_tbl s "+
				" where (:name is null or shain_nm like '%'||:name||'%')"
				+"and (:job is null or job = :job)"
			+"and( (:janru is null and :hobby is null)"
				+"or s.rank1 =(select h.hobby_code from hobby_tbl h where h.janru =:janru and h.hobby= :hobby)"
			+"or s.rank2 =(select h.hobby_code from hobby_tbl h where h.janru =:janru and h.hobby= :hobby)"
				+"or s.rank3 =(select h.hobby_code from hobby_tbl h where h.janru =:janru and h.hobby= :hobby))"
				,nativeQuery=true)
	public List<Team20_Shain> findmatch(@Param("name") String name,@Param("janru")String janru,@Param("hobby")
	String hobby,@Param("job")String job);
}
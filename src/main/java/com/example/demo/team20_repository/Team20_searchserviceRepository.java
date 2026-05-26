package com.example.demo.team20_repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team20_entity.Team20_Shain;

@Repository
public interface Team20_searchserviceRepository extends JpaRepository<Team20_Shain,String>{
	@Query(value="select * from team20_shain_tbl s "+
			" where (coalesce(:name, '') = '' or s.shainnm like '%'||:name||'%') " +
			" and (coalesce(:job, '') = '' or lower(s.job )= lower(:job)) " +
            " and ( " +
            "   (coalesce(:janru, '') = '' and coalesce(:hobby, '') = '') " +
            "   or s.rank1 in (select h.hobbycode from team20_hobby_tbl h where (coalesce(:janru, '') = '' or h.janru = :janru) and (coalesce(:hobby, '') = '' or h.hobby = :hobby)) " +
            "   or s.rank2 in (select h.hobbycode from team20_hobby_tbl h where (coalesce(:janru, '') = '' or h.janru = :janru) and (coalesce(:hobby, '') = '' or h.hobby = :hobby)) " +
            "   or s.rank3 in (select h.hobbycode from team20_hobby_tbl h where (coalesce(:janru, '') = '' or h.janru = :janru) and (coalesce(:hobby, '') = '' or h.hobby = :hobby))) "
				,nativeQuery=true)
	public List<Team20_Shain> findmatch(@Param("name") String name,@Param("janru")String janru,@Param("hobby")
	String hobby,@Param("job")String job);
}
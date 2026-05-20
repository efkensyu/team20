<<<<<<< HEAD:src/main/java/team20_repogitory/Team20_searchserviceRepository.java
/*package team20_repogitory;
=======
package com.example.demo.team20_repository;
>>>>>>> 86b392fae51fcdc7298064cf303535e5340d88dc:src/main/java/com/example/demo/team20_repository/Team20_searchserviceRepository.java

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.team20_entity.Team20_Shain;

@Repository
public interface Team20_searchserviceRepository extends JpaRepository<Team20_Shain,String>{
	@Query(value="select s from Team20_Shain s where (:name is null or s.shainNm like %:name%) and (:genre is null or s.genre = :genre) and (:hobby is null or s.hobby like %:hobby%)",nativeQuery=true)
	public List<Team20_Shain> findmatch(String name,String genre,String hobby);
		
	

}*/
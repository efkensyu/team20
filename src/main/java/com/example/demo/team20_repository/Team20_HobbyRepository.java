package com.example.demo.team20_repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team20_entity.Team20_Hobby;

@Repository
public interface Team20_HobbyRepository extends JpaRepository<Team20_Hobby, String> {

}
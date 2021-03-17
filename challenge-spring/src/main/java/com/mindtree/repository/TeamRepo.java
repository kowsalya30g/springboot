package com.mindtree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.entity.Team;



public interface TeamRepo extends JpaRepository<Team,Integer>{
	public Team findById(int id);

	public Team findByname(String name);
}

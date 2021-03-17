package com.mindtree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.entity.Player;


public interface PlayerRepo extends JpaRepository<Player,Integer>{
	public Player findById(int id);

}

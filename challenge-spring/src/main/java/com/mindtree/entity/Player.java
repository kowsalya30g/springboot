package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
public class Player {
	@Id
	private int id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name="team_id")
    private Team team;
	@JsonBackReference
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	private int age;
	private String role;
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Player(int id, String name, int age, String role) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}

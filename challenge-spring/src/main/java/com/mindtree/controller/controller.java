package com.mindtree.controller;



import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.Player;
import com.mindtree.entity.Team;
import com.mindtree.exception.ServiceException;
import com.mindtree.service.ServiceImp;


@RestController
public class controller {
	@Autowired
	private ServiceImp obj;
	
	@PostMapping("/addTeam")
	public Team addTeam(@RequestBody Team team) {
		obj.addTeamSer(team);
		return team;
	}
	
	@PostMapping("/addPlayer/{id}")
	public ResponseEntity<?> addPlayer(@RequestBody Player player,@PathVariable("id") int id) {
		obj.addPlayer(player,id);
		return new ResponseEntity<>("Players added",HttpStatus.OK);
	}
	
	@GetMapping("/getlist/{name}")
	public ResponseEntity<?> getAll(@PathVariable("name") String name) {
		String s;
		try {
			Team details = obj.getAllSer(name);
			return new ResponseEntity<>(details,HttpStatus.OK);
		} catch (ServiceException e) {
			s = e +"error";
			System.out.println("/n"+e.getLocalizedMessage());
		}
		return new ResponseEntity<>(s,HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") int id) {

		Map<String, Object> map = new LinkedHashMap<>();
		try {
			List<Player> player = obj.delete(id);
			return new ResponseEntity<>(map,HttpStatus.NO_CONTENT);
		} catch (ServiceException e) {
			System.out.println("\n" + e.getLocalizedMessage());
			map.put("Message", "Failed to fetch the employee");
		}
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updatePhone(@RequestBody String location,@PathVariable("id") int id) {
		try {
			Team details = obj.updateLocation(location,id);
			return new ResponseEntity<>(details,HttpStatus.OK);
		} catch (ServiceException e) {
			System.out.println(e);
			return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
		}
	}

}

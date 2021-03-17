package com.mindtree.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindtree.entity.Player;
import com.mindtree.entity.Team;
import com.mindtree.exception.ServiceException;
import com.mindtree.repository.PlayerRepo;
import com.mindtree.repository.TeamRepo;

@Service
public class ServiceImp {
	@Autowired
	private PlayerRepo playerr;
	@Autowired
	private TeamRepo teamr;
	
	public void addTeamSer(Team team) {
		// TODO Auto-generated method stub
		teamr.save(team);

	}

	public void addPlayer(Player player, int id) {
		// TODO Auto-generated method stub
		Team t = teamr.findById(id);
		player.setTeam(t);
	    player = playerr.save(player);
	}

	public Team getAllSer(String name) throws ServiceException{
		
		Team t = teamr.findByname(name);
		if(t==null) {
			throw new ServiceException("no players for this team");
		}else {
			return t;
		}
	}
	public List<Player> delete(int id) throws ServiceException {
		List<Player> list=new ArrayList<Player>();
		Player player=null;
		player=playerr.findById(id);
		if(player==null)
			throw new ServiceException("No Id like that");
		playerr.deleteById(id);
		playerr.findAll().forEach(list::add);
		return list;
		
		}

	public Team updateLocation(String location, int id) throws ServiceException {
		// TODO Auto-generated method stub
		Team team = teamr.findById(id);
		if(team==null)
		{
		throw new ServiceException("Id not found");	
        }
		else
       {
		team.setLocation(location);
		teamr.save(team);
		return team;
       }
	
	}

}

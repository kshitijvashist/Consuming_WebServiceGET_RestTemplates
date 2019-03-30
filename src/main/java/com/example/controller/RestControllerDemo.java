package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.dto.Sports;

@RestController
public class RestControllerDemo {
	private static final Logger logger = Logger.getLogger(RestControllerDemo.class);
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/getString")
	public String getUserData()
	{
		return "hello, Yes.. It is Working..!!!";
	}
	
	@GetMapping("/getCurrentSport")
	public Sports getCurrentSport()
	{
		
		Sports sport1=new Sports(1,"Cricket",11,"Field");
		
		return sport1;
	}
	
	@GetMapping("/getMapSport")
	public Map<Sports,Integer> getMapSport()
	{
		Sports sport1=new Sports(1,"Cricket",11,"Field");
		Map<Sports,Integer> map=new HashMap<Sports,Integer>();
				map.put(sport1, 1);
	return map;
	}
	
	@GetMapping("/checkForInput/{inputId}/{userId}")
	public int getInputValue(@PathVariable int inputId,@PathVariable int userId)
	{
		return inputId+userId;
	}
	@GetMapping("/getAllSports")
	public List<Sports> getAllSports()
	{
		logger.info("hooooooooooooooooooo");
		logger.info("hooooooooooooooooooo");
		logger.info("hooooooooooooooooooo");
		logger.info("hooooooooooooooooooo");
		logger.info("hooooooooooooooooooo");
		
		List <Sports> sportsList=new ArrayList<Sports>();
		
		Sports sport1=new Sports(1,"Cricket",11,"Field");
		Sports sport2=new Sports(1,"Football",12,"Field");
		Sports sport3=new Sports(3,"Hockey",11,"Field");
		
		sportsList.add(sport1);sportsList.add(sport2);
		sportsList.add(sport3);
		
		return sportsList;
	}
	
	@GetMapping("/consumeRestservice")
	public Sports consumeAllService()
	{
		//RestTemplate restTemplate =new RestTemplate();
		
		String getAllURL="http://localhost:8080/getCurrentSport";
		
		ResponseEntity<Sports> getResponse=restTemplate.getForEntity(getAllURL, Sports.class);
		
		Sports sports=restTemplate.getForObject(getAllURL, Sports.class);
		
		System.out.println(getResponse);
		System.out.println(sports);
		
		if(getResponse.getBody()!=null)
			System.out.println(getResponse.getBody().toString());
		
		else
			System.out.println(getResponse.getStatusCodeValue());
		
		System.out.println(sports.getSportsName());
		
		return sports;
	}
	
	@GetMapping("/consumeRestListService")
	public List<Sports> getListRestService()
	{
		String getAllURL="http://localhost:8080/getAllSports";
//		SportList getSportsList= restTemplate.getForObject(getAllURL, SportList.class);
//		
//		List<Sports> listSports=getSportsList.getSportsList();
//		
//		ResponseEntity<SportList> response=restTemplate.getForEntity(getAllURL, SportList.class);
//		
//		System.out.println(response.getBody().toString());
		
		ResponseEntity<List<Sports>> response = restTemplate.exchange(
				getAllURL,
				  HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<List<Sports>>(){});
				List<Sports> sportsList = response.getBody();
				System.out.println(sportsList);
		
		return sportsList;
	}
	
	@PostMapping("/create/{inputId}")
	public Sports createSports(@PathVariable int inputId,@RequestBody Sports sport)
	{
		System.out.println("Post Mapping....1");
		System.out.println(sport.getSportsName());
		
		return sport;
	}

	
	@PutMapping("/edit/{inputId}")
	public Sports editSports(@PathVariable int inputId,@RequestBody Sports sport)
	{
		System.out.println("Put Mapping....1");
		System.out.println(sport.getSportsName());
		
		return sport;
	}
	
	@DeleteMapping("/delete/{inputId}")
	public int deleteSports(@PathVariable int inputId)
	{
		return inputId;
	}
}

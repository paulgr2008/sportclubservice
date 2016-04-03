package sportclub.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import sportclub.interfaces.ISportclubRepository;
import sportclub.model.*;
import sportclub.profile.*;



@Controller
@Scope("session")
@RequestMapping("/")
public class SportclubRestController {
	@Autowired
	ISportclubRepository profiles;
	
	@RequestMapping({"/","home"})
	public String home(){
		return "success";
		
	}
	@RequestMapping(value=SportclubConstants.CREATE_RANDOM_PROFILE, method=RequestMethod.PUT)
	public @ResponseBody boolean createrandomProfile(){
		try {
			profiles.addRandomRoles(3);
		} catch (JsonProcessingException e) {
			
		}
		profiles.addRandomProfile();
		//profiles.addRandomEvent();
		System.out.println("random profile added");
			return true;
	}
	
	
	@RequestMapping(value=SportclubConstants.CREATE_RANDOM_TRAININGPOOL, method=RequestMethod.PUT)
	public @ResponseBody boolean createrandomTrainingPool(){
		
		profiles.addRandomTrainingPool();
		profiles.addRandomEvent();
		
		System.out.println("random TrainingPool added");
			return true;
	}
	
	@RequestMapping(value=SportclubConstants.CREATE_RANDOM_TRAINING, method=RequestMethod.PUT)
	public @ResponseBody boolean createrandomTraining(){
		
		
		profiles.addRandomTraining();
		System.out.println("random Training added");
			return true;
	}
	
	
	@RequestMapping(value=SportclubConstants.CREATE_RANDOM_GAME, method=RequestMethod.PUT)
	public @ResponseBody boolean createRandomGame(){
		
		
		profiles.addRandomGame();
		System.out.println("random game added");
			return true;
	}
	
	
	@RequestMapping(value=SportclubConstants.REMOVE+"/{id}", method=RequestMethod.PUT)
	public @ResponseBody boolean remove(@PathVariable int id){
		
		return profiles.removeProfile(id);
	}
	
	@RequestMapping(value=SportclubConstants.GET_PROFILES, method=RequestMethod.GET)
	public @ResponseBody Iterable<Profiler> getProfiles() {
		
		return profiles.getProfiles();
	}
	@RequestMapping(value=SportclubConstants.ADD_PROFILE, method=RequestMethod.PUT)
	public @ResponseBody void addProfile(@RequestBody Profiler profile){
		/*profiles.addProfile(profile);*/
		
		System.out.println(profile);
		
	}
	@RequestMapping(value=SportclubConstants.ADD_TEAM, method=RequestMethod.POST)
	public @ResponseBody void addTeam(@RequestBody Team team){
		
		profiles.addTeam(team);
		System.out.println(team);

		
	}
	
	
	/*@RequestMapping(value=SportclubConstants.GET_TEAM, method=RequestMethod.POST)
	public @ResponseBody void getTeam(@RequestBody Team team){
		
		profiles.getTeam(team);
		System.out.println(team);

		
	}*/
	
	@RequestMapping(value=SportclubConstants.ALL_QUERIES, method=RequestMethod.PUT)
	public @ResponseBody void getAnyRequest(@RequestBody String jpql) throws JsonGenerationException, JsonMappingException, IOException {
		
		Iterable<String> it = profiles.getAnyRequest(jpql);
		
		
		for(String str: it){
			
			System.out.println(str);
			
		};
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@RequestMapping(value=SportclubConstants.GET_PERSONS_BY_NAME+"/{name}", method=RequestMethod.GET)
//	public @ResponseBody Iterable<Person> getPersonsByName (@PathVariable String name) {
//		return persons.getPersonsByCity(name);
//	}
//	
//	@RequestMapping(value=SportclubConstants.GET_PERSONS_BY_CITY+"/{city}", method=RequestMethod.GET)
//	public @ResponseBody Iterable<Person> getPersonsByCity (@PathVariable String city) {
//		return persons.getPersonsByCity(city);
//	}
		
	
}

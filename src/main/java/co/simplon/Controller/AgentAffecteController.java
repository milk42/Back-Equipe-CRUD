package co.simplon.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ModelEntity.AgentAffecte;
import co.simplon.Repository.IRepositoryAgentAffecte;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/agentAffecte")
public class AgentAffecteController{

	@Autowired
	private IRepositoryAgentAffecte iRepositoryAgentAffecte;
	
	@GetMapping(value="/list")
	public List<AgentAffecte> getListAgentAffecte() {
		return iRepositoryAgentAffecte.findAll();	
	}
	
	@PostMapping(value="/create") 
	public AgentAffecte createAgentAffecte(@RequestBody AgentAffecte personnel) {
		return iRepositoryAgentAffecte.save(personnel);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteAgentAffecte(@PathVariable Long id) {
		iRepositoryAgentAffecte.deleteById(id);
	}
	
	@GetMapping(value="detail/{id}")
	public Optional<AgentAffecte> getAgentAffecte(@PathVariable Long id) {
		return iRepositoryAgentAffecte.findById(id);
	}

	@PutMapping(value="/edit/{id}") 
	public AgentAffecte editAgentAffecte(@RequestBody AgentAffecte agentAffecte,@PathVariable ("id") Long id) {
		AgentAffecte agentAffecteToUpdate = iRepositoryAgentAffecte.getOne(id);
		agentAffecteToUpdate.setGrade(agentAffecte.getGrade());
		agentAffecteToUpdate.setDroitAcces(agentAffecte.getDroitAcces());
		agentAffecteToUpdate.setIdentifiant(agentAffecte.getIdentifiant());
		agentAffecteToUpdate.setPassword(agentAffecte.getPassword());
		agentAffecteToUpdate.setAffaire(agentAffecte.getAffaire());
		return iRepositoryAgentAffecte.save(agentAffecteToUpdate);
	}

}

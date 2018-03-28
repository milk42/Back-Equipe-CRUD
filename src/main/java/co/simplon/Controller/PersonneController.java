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

import co.simplon.ModelEntity.Personne;
import co.simplon.Repository.IRepositoryPersonne;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/personne")
public class PersonneController {
	
	@Autowired
	private IRepositoryPersonne iRepositoryPersonne;	
	
	@GetMapping(value="/list")
	public List<Personne> getListPersonne() {		
		return iRepositoryPersonne.findAll();
	}
	
	@PostMapping(value="/create") 
	public Personne createPersonne(@RequestBody Personne personne) {
		return iRepositoryPersonne.save(personne);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deletePersonne(@PathVariable Long id) {
		iRepositoryPersonne.deleteById(id);
	}
	
	@GetMapping(value="detail/{id}")
	public Optional<Personne> getPersonne(@PathVariable Long id) {
		return iRepositoryPersonne.findById(id);
	}

	@PutMapping(value="/edit/{id}") 
	public Personne editPersonne(@RequestBody Personne personne,@PathVariable ("id") Long id) {
		Personne personneToUpdate = iRepositoryPersonne.getOne(id);
		personneToUpdate.setNom(personne.getNom());
		personneToUpdate.setPrenom(personne.getPrenom());
		return iRepositoryPersonne.save(personneToUpdate);
	}
}

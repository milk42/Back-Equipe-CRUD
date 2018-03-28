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
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ModelEntity.PersonneModel;
import co.simplon.Repository.IRepositoryPersonne;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class PersonneController {

	
	@Autowired
	private IRepositoryPersonne iRepositoryPersonne;
	
	
	@GetMapping(value="/personnes")
	public List<PersonneModel> GetPersonne() {
		
		return iRepositoryPersonne.findAll();
		
	}
	
	@PostMapping(value="/ajoutPersonne") 
	public PersonneModel PostPersonne(@RequestBody PersonneModel personne) {
		return iRepositoryPersonne.save(personne);
	}
	

	@DeleteMapping(value="/supprimePersonne/{id}")
	public void DeletePersonne(@PathVariable Long id) {
		iRepositoryPersonne.deleteById(id);
	}
	
	@GetMapping(value="personne/{id}")
	public Optional<PersonneModel> GetPersonne(@PathVariable Long id) {
		return iRepositoryPersonne.findById(id);
	}
	


	@PutMapping(value="/editPersonne/{id}") 
	public PersonneModel editPersonne(@RequestBody PersonneModel personne,@PathVariable ("id") Long id) {
		PersonneModel personneToUpdate = iRepositoryPersonne.getOne(id);
		personneToUpdate.setNom(personne.getNom());
		personneToUpdate.setPrenom(personne.getPrenom());
		
		return iRepositoryPersonne.save(personneToUpdate);
	}
}

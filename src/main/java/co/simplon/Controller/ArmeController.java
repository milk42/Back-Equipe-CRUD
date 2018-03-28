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

import co.simplon.ModelEntity.ArmeModel;
import co.simplon.Repository.IRepositoryArme;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ArmeController {
	
	@Autowired 
	private IRepositoryArme iRepositoryArme;
	
	
	
	@GetMapping(value="/armes")
	public List<ArmeModel> GetArme() {
		return iRepositoryArme.findAll();
		
	}
	
	
	
	@PostMapping(value="/ajoutArme") 
	public ArmeModel PostArme(@RequestBody ArmeModel arme) {
		return iRepositoryArme.save(arme);
	}
	
	

	@DeleteMapping(value="/supprimeArme/{id}")
	public void DeleteArme(@PathVariable Long id) {
		iRepositoryArme.deleteById(id);
	}
	
	
	
	@GetMapping(value="arme/{id}")
	public Optional<ArmeModel> GetArme(@PathVariable Long id) {
		return iRepositoryArme.findById(id);
	}
	


	@PutMapping(value="/editArme/{id}") 
	public ArmeModel editArme(@RequestBody ArmeModel arme,@PathVariable ("id") Long id) {
		ArmeModel armeToUpdate = iRepositoryArme.getOne(id);
		armeToUpdate.setModele(arme.getModele());
		armeToUpdate.setType(arme.getType());
		armeToUpdate.setAffaire(arme.getAffaire());

		return iRepositoryArme.save(armeToUpdate);
	}

}

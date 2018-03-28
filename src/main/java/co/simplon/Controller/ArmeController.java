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

import co.simplon.ModelEntity.Arme;
import co.simplon.Repository.IRepositoryArme;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/arme")
public class ArmeController {
	
	@Autowired 
	private IRepositoryArme iRepositoryArme;
	
	@GetMapping(value="/list")
	public List<Arme> getListArme() {
		return iRepositoryArme.findAll();
	}
	
	@PostMapping(value="/create") 
	public Arme createArme(@RequestBody Arme arme) {
		return iRepositoryArme.save(arme);
	}

	@DeleteMapping(value="/delete/{id}")
	public void deleteArme(@PathVariable Long id) {
		iRepositoryArme.deleteById(id);
	}
	
	@GetMapping(value="detail/{id}")
	public Optional<Arme> getArme(@PathVariable Long id) {
		return iRepositoryArme.findById(id);
	}

	@PutMapping(value="/edit/{id}") 
	public Arme editArme(@RequestBody Arme arme,@PathVariable ("id") Long id) {
		Arme armeToUpdate = iRepositoryArme.getOne(id);
		armeToUpdate.setModele(arme.getModele());
		armeToUpdate.setType(arme.getType());
		armeToUpdate.setAffaire(arme.getAffaire());
		return iRepositoryArme.save(armeToUpdate);
	}

}

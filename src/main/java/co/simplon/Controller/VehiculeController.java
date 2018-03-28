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

import co.simplon.ModelEntity.Vehicule;
import co.simplon.Repository.IRepositoryVehicule;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/vehicule")
public class VehiculeController {
	
	@Autowired
	private IRepositoryVehicule iRepositoryVehicule;
		
	@GetMapping(value="/list")
	public List<Vehicule> getArme() {	
		return iRepositoryVehicule.findAll();		
	}
	
	@PostMapping(value="/create") 
	public Vehicule postVehicule(@RequestBody Vehicule vehicule) {
		return iRepositoryVehicule.save(vehicule);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteVehicule(@PathVariable Long id) {
		iRepositoryVehicule.deleteById(id);
	}
	
	@GetMapping(value="/detail/{id}")
	public Optional<Vehicule> getVehicule(@PathVariable Long id) {
		return iRepositoryVehicule.findById(id);
	}
	
	@PutMapping(value="/edit/{id}") 
	public Vehicule editVehicule(@RequestBody Vehicule vehicule,@PathVariable ("id") Long id) {
		Vehicule vehiculeToUpdate = iRepositoryVehicule.getOne(id);		
		vehiculeToUpdate.setType(vehicule.getType());
		vehiculeToUpdate.setMarque(vehicule.getMarque());
		vehiculeToUpdate.setModele(vehicule.getModele());
		vehiculeToUpdate.setImmatriculation(vehicule.getImmatriculation());
		vehiculeToUpdate.setCouleur(vehicule.getCouleur());
		vehiculeToUpdate.setListVehiculeImplique(vehicule.getListVehiculeImplique());
		vehiculeToUpdate.setPersonne(vehicule.getPersonne());		
		return iRepositoryVehicule.save(vehiculeToUpdate);
	}

}

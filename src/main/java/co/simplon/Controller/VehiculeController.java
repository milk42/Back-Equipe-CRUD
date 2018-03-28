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

import co.simplon.ModelEntity.VehiculeModel;
import co.simplon.Repository.IRepositoryVehicule;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class VehiculeController {
	
	@Autowired
	private IRepositoryVehicule iRepositoryVehicule;
	
	
	@GetMapping(value="/vehicules")
	public List<VehiculeModel> GetArme() {
		
		return iRepositoryVehicule.findAll();
		
	}
	
	@PostMapping(value="/ajoutVehicule") 
	public VehiculeModel PostVehicule(@RequestBody VehiculeModel vehicule) {
		return iRepositoryVehicule.save(vehicule);
	}
	

	@DeleteMapping(value="/supprimeVehicule/{id}")
	public void DeleteVehicule(@PathVariable Long id) {
		iRepositoryVehicule.deleteById(id);
	}
	
	@GetMapping(value="vehicule/{id}")
	public Optional<VehiculeModel> GetVehicule(@PathVariable Long id) {
		return iRepositoryVehicule.findById(id);
	}
	


	@PutMapping(value="/editVehicule/{id}") 
	public VehiculeModel editVehicule(@RequestBody VehiculeModel vehicule,@PathVariable ("id") Long id) {
		VehiculeModel vehiculeToUpdate = iRepositoryVehicule.getOne(id);
		vehiculeToUpdate.setType(vehicule.getType());
		vehiculeToUpdate.setMarque(vehicule.getMarque());
		vehiculeToUpdate.setModele(vehicule.getModele());
		vehiculeToUpdate.setImmatriculation(vehicule.getImmatriculation());
		vehiculeToUpdate.setCouleur(vehicule.getCouleur());
		vehiculeToUpdate.setAffaire(vehicule.getAffaire());
		
		return iRepositoryVehicule.save(vehiculeToUpdate);
	}


}

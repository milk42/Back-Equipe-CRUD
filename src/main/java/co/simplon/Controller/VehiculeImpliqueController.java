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

import co.simplon.ModelEntity.VehiculeImplique;
import co.simplon.Repository.IRepositoryVehiculeImplique;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/vehiculeImplique")
public class VehiculeImpliqueController {
	
	@Autowired
	private IRepositoryVehiculeImplique iRepositoryVehiculeImplique;
	
	@GetMapping(value="/list")
	public List<VehiculeImplique> getListVehiculeImplique() {
		return iRepositoryVehiculeImplique.findAll();		
	}
	
	@PostMapping(value="/create") 
	public VehiculeImplique createVehiculeImplique(@RequestBody VehiculeImplique vehiculeImplique) {
		return iRepositoryVehiculeImplique.save(vehiculeImplique);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteVehiculeImplique(@PathVariable Long id) {
		iRepositoryVehiculeImplique.deleteById(id);
	}
	
	@GetMapping(value="detail/{id}")
	public Optional<VehiculeImplique> getVehiculeImplique(@PathVariable Long id) {
		return iRepositoryVehiculeImplique.findById(id);
	}
	
	@PutMapping(value="/edit/{id}") 
	public VehiculeImplique editVehiculeImplique(@RequestBody VehiculeImplique vehiculeImplique,@PathVariable ("id") Long id) {
		VehiculeImplique vehiculeImpliqueToUpdate = iRepositoryVehiculeImplique.getOne(id);
		vehiculeImpliqueToUpdate.setDateImplication(vehiculeImplique.getDateImplication());
		vehiculeImpliqueToUpdate.setVehicule(vehiculeImplique.getVehicule());
		vehiculeImpliqueToUpdate.setAffaire(vehiculeImplique.getAffaire());	
		return iRepositoryVehiculeImplique.save(vehiculeImpliqueToUpdate);
	}

}

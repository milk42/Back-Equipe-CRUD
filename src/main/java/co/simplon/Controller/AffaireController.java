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

import co.simplon.ModelEntity.AffaireModel;
import co.simplon.Repository.IRepositoryAffaire;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class AffaireController {

	
	@Autowired
	private IRepositoryAffaire iRepositoryAffaire;
	
	
	@GetMapping(value="/affaires")
	public List<AffaireModel> GetAffaire() {
		
		return iRepositoryAffaire.findAll();
		
	}
	
	@PostMapping(value="/ajoutAffaire") 
	public AffaireModel PostAffaire(@RequestBody AffaireModel affaire) {
		return iRepositoryAffaire.save(affaire);
	}
	

	@DeleteMapping(value="/supprimeAffaire/{id}")
	public void DeleteAffaire(@PathVariable Long id) {
		iRepositoryAffaire.deleteById(id);
	}
	
	@GetMapping(value="affaire/{id}")
	public Optional<AffaireModel> GetAffaire(@PathVariable Long id) {
		return iRepositoryAffaire.findById(id);
	}
	


	@PutMapping(value="/editAffaire/{id}") 
	public AffaireModel editAffaire(@RequestBody AffaireModel affaire,@PathVariable ("id") Long id) {
		AffaireModel affaireToUpdate = iRepositoryAffaire.getOne(id);
		affaireToUpdate.setNom(affaire.getNom());
		affaireToUpdate.setDate_creation(affaire.getDate_creation());
		affaireToUpdate.setDate_cloture(affaire.getDate_cloture());
		affaireToUpdate.setLieu(affaire.getLieu());
		affaireToUpdate.setRapport(affaire.getRapport());
		affaireToUpdate.setListVehicule(affaire.getListVehicule());
		affaireToUpdate.setListArme(affaire.getListArme());
		affaireToUpdate.setListAgentAffecte(affaire.getListAgentAffecte());
		affaireToUpdate.setListSuspect(affaire.getListSuspect());
		affaireToUpdate.setListTemoin(affaire.getListTemoin());
		affaireToUpdate.setListVictime(affaire.getListVictime());
		
		return iRepositoryAffaire.save(affaireToUpdate);
	}


}

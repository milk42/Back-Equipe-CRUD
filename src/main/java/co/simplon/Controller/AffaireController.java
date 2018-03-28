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

import co.simplon.ModelEntity.Affaire;
import co.simplon.Repository.IRepositoryAffaire;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/affaire")
public class AffaireController {

	@Autowired
	private IRepositoryAffaire iRepositoryAffaire;
	
	@GetMapping(value="/list")
	public List<Affaire> getListAffaire() {
		return iRepositoryAffaire.findAll();
	}
	
	@PostMapping(value="/create") 
	public Affaire createAffaire(@RequestBody Affaire affaire) {
		return iRepositoryAffaire.save(affaire);
	}

	@DeleteMapping(value="/delete/{id}")
	public void deleteAffaire(@PathVariable Long id) {
		iRepositoryAffaire.deleteById(id);
	}
	
	@GetMapping(value="detail/{id}")
	public Optional<Affaire> getAffaire(@PathVariable Long id) {
		return iRepositoryAffaire.findById(id);
	}
	
	@PutMapping(value="/edit/{id}") 
	public Affaire editAffaire(@RequestBody Affaire affaire,@PathVariable ("id") Long id) {
		Affaire affaireToUpdate = iRepositoryAffaire.getOne(id);
		affaireToUpdate.setNom(affaire.getNom());
		affaireToUpdate.setDate_creation(affaire.getDate_creation());
		affaireToUpdate.setDate_cloture(affaire.getDate_cloture());
		affaireToUpdate.setLieu(affaire.getLieu());
		affaireToUpdate.setRapport(affaire.getRapport());
		affaireToUpdate.setListVehiculeImplique(affaire.getListVehiculeImplique());
		affaireToUpdate.setListArmeImpliquee(affaire.getListArmeImpliquee());
		affaireToUpdate.setListAgentAffecte(affaire.getListAgentAffecte());
		affaireToUpdate.setListSuspect(affaire.getListSuspect());
		affaireToUpdate.setListTemoin(affaire.getListTemoin());
		affaireToUpdate.setListVictime(affaire.getListVictime());
		return iRepositoryAffaire.save(affaireToUpdate);
	}


}

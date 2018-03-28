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

import co.simplon.ModelEntity.Suspect;
import co.simplon.Repository.IRepositorySuspect;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/suspect")
public class SuspectController {
	
	@Autowired
	private IRepositorySuspect iRepositorySuspect;
		
	@GetMapping(value="/list")
	public List<Suspect> getListSuspect() {	
		return iRepositorySuspect.findAll();	
	}
	
	@PostMapping(value="/create") 
	public Suspect createSuspect(@RequestBody Suspect suspect) {
		return iRepositorySuspect.save(suspect);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteSuspect(@PathVariable Long id) {
		iRepositorySuspect.deleteById(id);
	}
	
	@GetMapping(value="detail/{id}")
	public Optional<Suspect> getSuspect(@PathVariable Long id) {
		return iRepositorySuspect.findById(id);
	}

	@PutMapping(value="/edit/{id}") 
	public Suspect editSuspect(@RequestBody Suspect suspect,@PathVariable ("id") Long id) {
		Suspect suspectToUpdate = iRepositorySuspect.getOne(id);
		suspectToUpdate.setPseudo(suspect.getPseudo());
		suspectToUpdate.setPhoto(suspect.getPhoto());
		suspectToUpdate.setSigneParticulier(suspect.getSigneParticulier());
		suspectToUpdate.setCouleurPeau(suspect.getCouleurPeau());
		suspectToUpdate.setCouleurCheveux(suspect.getCouleurCheveux());
		suspectToUpdate.setTaille(suspect.getTaille());
		suspectToUpdate.setAffaire(suspect.getAffaire());
		return iRepositorySuspect.save(suspectToUpdate);
	}

}

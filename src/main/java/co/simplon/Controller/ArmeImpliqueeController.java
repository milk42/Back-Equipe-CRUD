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

import co.simplon.ModelEntity.ArmeImpliquee;
import co.simplon.Repository.IRepositoryArmeImpliquee;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/armeImpliquee")
public class ArmeImpliqueeController {

	@Autowired
	private IRepositoryArmeImpliquee iRepositoryArmeImpliquee;
	
	@GetMapping(value="/list")
	public List<ArmeImpliquee> getListArmeImpliquee() {
		return iRepositoryArmeImpliquee.findAll();	
	}
	
	@PostMapping(value="/create") 
	public ArmeImpliquee createArmeImplique(@RequestBody ArmeImpliquee armeImpliquee) {
		return iRepositoryArmeImpliquee.save(armeImpliquee);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteArmeImpliquee(@PathVariable Long id) {
		iRepositoryArmeImpliquee.deleteById(id);
	}
	
	@GetMapping(value="detail/{id}")
	public Optional<ArmeImpliquee> getArmeImpliquee(@PathVariable Long id) {
		return iRepositoryArmeImpliquee.findById(id);
	}
	
	@PutMapping(value="/edit/{id}") 
	public ArmeImpliquee editArmeImpliquee(@RequestBody ArmeImpliquee armeImpliquee, @PathVariable ("id") Long id) {
		ArmeImpliquee armeImpliqueeToUpdate = iRepositoryArmeImpliquee.getOne(id);
		armeImpliqueeToUpdate.setDateImplication(armeImpliquee.getDateImplication());
		armeImpliqueeToUpdate.setArme(armeImpliquee.getArme());
		armeImpliqueeToUpdate.setAffaire(armeImpliquee.getAffaire());
		return iRepositoryArmeImpliquee.save(armeImpliqueeToUpdate);
	}
}

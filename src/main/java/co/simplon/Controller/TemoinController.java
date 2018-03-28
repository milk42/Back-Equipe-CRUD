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

import co.simplon.ModelEntity.TemoinModel;
import co.simplon.Repository.IRepositoryTemoin;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TemoinController {
	
	@Autowired
	private IRepositoryTemoin iRepositoryTemoin;
	
	
	@GetMapping(value="/temoins")
	public List<TemoinModel> GetTemoin() {
		
		return iRepositoryTemoin.findAll();
		
	}
	
	@PostMapping(value="/ajoutTemoin") 
	public TemoinModel PostTemoin(@RequestBody TemoinModel temoin) {
		return iRepositoryTemoin.save(temoin);
	}
	

	@DeleteMapping(value="/supprimeTemoin/{id}")
	public void DeleteTemoin(@PathVariable Long id) {
		iRepositoryTemoin.deleteById(id);
	}
	
	@GetMapping(value="temoin/{id}")
	public Optional<TemoinModel> GetTemoin(@PathVariable Long id) {
		return iRepositoryTemoin.findById(id);
	}
	


	@PutMapping(value="/editTemoin/{id}") 
	public TemoinModel editTemoin(@RequestBody TemoinModel temoin,@PathVariable ("id") Long id) {
		TemoinModel temoinToUpdate = iRepositoryTemoin.getOne(id);
		temoinToUpdate.setTemoignage(temoin.getTemoignage());
		temoinToUpdate.setAffaire(temoin.getAffaire());
		
		return iRepositoryTemoin.save(temoinToUpdate);
	}


}

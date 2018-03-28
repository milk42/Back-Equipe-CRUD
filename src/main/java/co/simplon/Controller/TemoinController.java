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

import co.simplon.ModelEntity.Temoin;
import co.simplon.Repository.IRepositoryTemoin;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/temoin")
public class TemoinController {
	
	@Autowired
	private IRepositoryTemoin iRepositoryTemoin;
	
	@GetMapping(value="/list")
	public List<Temoin> getListTemoin() {	
		return iRepositoryTemoin.findAll();	
	}
	
	@PostMapping(value="/create") 
	public Temoin createTemoin(@RequestBody Temoin temoin) {
		return iRepositoryTemoin.save(temoin);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteTemoin(@PathVariable Long id) {
		iRepositoryTemoin.deleteById(id);
	}
	
	@GetMapping(value="detail/{id}")
	public Optional<Temoin> getTemoin(@PathVariable Long id) {
		return iRepositoryTemoin.findById(id);
	}

	@PutMapping(value="/edit/{id}") 
	public Temoin editTemoin(@RequestBody Temoin temoin,@PathVariable ("id") Long id) {
		Temoin temoinToUpdate = iRepositoryTemoin.getOne(id);
		temoinToUpdate.setTemoignage(temoin.getTemoignage());
		temoinToUpdate.setAffaire(temoin.getAffaire());		
		return iRepositoryTemoin.save(temoinToUpdate);
	}

}

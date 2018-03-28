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

import co.simplon.ModelEntity.Victime;
import co.simplon.Repository.IRepositoryVictime;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/victime")
public class VictimeController {
	
	@Autowired
	private IRepositoryVictime iRepositoryVictime;
		
	@GetMapping(value="/list")
	public List<Victime> getListVictime() {
		return iRepositoryVictime.findAll();
	}
	
	@PostMapping(value="/create") 
	public Victime createVictime(@RequestBody Victime victime) {
		return iRepositoryVictime.save(victime);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteVictime(@PathVariable Long id) {
		iRepositoryVictime.deleteById(id);
	}
	
	@GetMapping(value="detail/{id}")
	public Optional<Victime> getVictime(@PathVariable Long id) {
		return iRepositoryVictime.findById(id);
	}

	@PutMapping(value="/edit/{id}") 
	public Victime editVictime(@RequestBody Victime victime,@PathVariable ("id") Long id) {
		Victime victimeToUpdate = iRepositoryVictime.getOne(id);
		victimeToUpdate.setTypeAgression(victime.getTypeAgression());
		victimeToUpdate.setAffaire(victime.getAffaire());
		return iRepositoryVictime.save(victimeToUpdate);
	}

}

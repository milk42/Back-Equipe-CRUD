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

import co.simplon.ModelEntity.VictimeModel;
import co.simplon.Repository.IRepositoryVictime;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class VictimeController {
	
	@Autowired
	private IRepositoryVictime iRepositoryVictime;
	
	
	@GetMapping(value="/victimes")
	public List<VictimeModel> GetVictime() {
		
		return iRepositoryVictime.findAll();
		
	}
	
	@PostMapping(value="/ajoutVictime") 
	public VictimeModel PostVictime(@RequestBody VictimeModel victime) {
		return iRepositoryVictime.save(victime);
	}
	

	@DeleteMapping(value="/supprimeVictime/{id}")
	public void DeleteVictime(@PathVariable Long id) {
		iRepositoryVictime.deleteById(id);
	}
	
	@GetMapping(value="victime/{id}")
	public Optional<VictimeModel> GetVictime(@PathVariable Long id) {
		return iRepositoryVictime.findById(id);
	}
	


	@PutMapping(value="/editVictime/{id}") 
	public VictimeModel editVictime(@RequestBody VictimeModel victime,@PathVariable ("id") Long id) {
		VictimeModel victimeToUpdate = iRepositoryVictime.getOne(id);
		victimeToUpdate.setTypeAgression(victime.getTypeAgression());
		victimeToUpdate.setAffaire(victime.getAffaire());
		
		return iRepositoryVictime.save(victimeToUpdate);
	}


}

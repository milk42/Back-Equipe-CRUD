package co.simplon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.ModelEntity.Vehicule;

@Repository
public interface IRepositoryVehicule extends JpaRepository<Vehicule, Long>{

}

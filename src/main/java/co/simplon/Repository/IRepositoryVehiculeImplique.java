package co.simplon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.ModelEntity.VehiculeImplique;

@Repository
public interface IRepositoryVehiculeImplique extends JpaRepository<VehiculeImplique, Long>{

}

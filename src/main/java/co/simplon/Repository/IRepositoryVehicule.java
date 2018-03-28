package co.simplon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.ModelEntity.VehiculeModel;

public interface IRepositoryVehicule extends JpaRepository<VehiculeModel, Long>{

}

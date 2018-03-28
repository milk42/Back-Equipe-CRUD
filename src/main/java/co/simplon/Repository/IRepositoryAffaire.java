package co.simplon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.ModelEntity.AffaireModel;

public interface IRepositoryAffaire  extends JpaRepository<AffaireModel, Long>{

}

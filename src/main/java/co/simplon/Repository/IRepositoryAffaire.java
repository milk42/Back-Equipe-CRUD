package co.simplon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.ModelEntity.Affaire;

@Repository
public interface IRepositoryAffaire  extends JpaRepository<Affaire, Long>{

}

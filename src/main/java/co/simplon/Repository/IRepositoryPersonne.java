package co.simplon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.ModelEntity.Personne;

@Repository
public interface IRepositoryPersonne extends JpaRepository<Personne, Long>{

}

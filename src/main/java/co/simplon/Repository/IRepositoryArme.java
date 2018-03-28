package co.simplon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.ModelEntity.Arme;

@Repository
public interface IRepositoryArme extends JpaRepository<Arme, Long>{

}

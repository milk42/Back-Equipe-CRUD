package co.simplon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.ModelEntity.PersonneModel;

public interface IRepositoryPersonne extends JpaRepository<PersonneModel, Long>{

}

package co.simplon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.ModelEntity.SuspectModel;

public interface IRepositorySuspect extends JpaRepository<SuspectModel, Long>{

}

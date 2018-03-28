package co.simplon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.ModelEntity.VictimeModel;

public interface IRepositoryVictime extends JpaRepository<VictimeModel, Long> {

}

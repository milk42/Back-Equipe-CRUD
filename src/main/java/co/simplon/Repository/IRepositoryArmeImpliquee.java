package co.simplon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.ModelEntity.ArmeImpliquee;

@Repository
public interface IRepositoryArmeImpliquee extends JpaRepository<ArmeImpliquee, Long>{

}

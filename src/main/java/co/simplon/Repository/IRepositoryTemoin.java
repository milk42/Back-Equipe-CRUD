package co.simplon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.ModelEntity.Temoin;

@Repository
public interface IRepositoryTemoin extends JpaRepository<Temoin, Long>{

}

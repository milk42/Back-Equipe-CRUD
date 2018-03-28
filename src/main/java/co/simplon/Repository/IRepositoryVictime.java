package co.simplon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.ModelEntity.Victime;

@Repository
public interface IRepositoryVictime extends JpaRepository<Victime, Long> {

}

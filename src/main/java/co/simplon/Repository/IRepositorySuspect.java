package co.simplon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.ModelEntity.Suspect;

@Repository
public interface IRepositorySuspect extends JpaRepository<Suspect, Long>{

}

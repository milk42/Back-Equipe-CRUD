package co.simplon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.ModelEntity.AgentAffecte;

@Repository
public interface IRepositoryAgentAffecte extends JpaRepository<AgentAffecte, Long>{

}

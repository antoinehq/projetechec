package projetechec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetechec.entity.HistoriqueElo;
import projetechec.entity.HistoriqueEloKey;

public interface HistoriqueEloRepository extends JpaRepository<HistoriqueElo, HistoriqueEloKey> {

}

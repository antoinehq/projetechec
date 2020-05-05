package projetechec.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetechec.entity.HistoriqueElo;
import projetechec.entity.HistoriqueEloKey;

public interface HistoriqueEloRepository extends JpaRepository<HistoriqueElo, HistoriqueEloKey> {

	@Query("select h from historique_elo h left join fetch h.id.date where h.id.date = :date")
	List<HistoriqueElo> findByDate(@Param("date") Date date, Pageable pageable);

	@Query("select h from historique_elo h left join fetch h.id.membre as m where m.id = :id")
	List<HistoriqueElo> findByMembre(@Param("id") Integer id, Pageable pageable);

}

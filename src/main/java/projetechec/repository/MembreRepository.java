package projetechec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetechec.entity.Club;
import projetechec.entity.HistoriqueElo;
import projetechec.entity.Membre;
import projetechec.entity.Tournoi;

public interface MembreRepository extends JpaRepository<Membre, Integer> {

	Optional<Membre> findByNomAndPrenom(String nom, String prenom);

	List<Membre> findByClub(Club club);

	List<Membre> findByElo(Integer elo);

	@Query("select MAX(e.elo) from HistoriqueElo e where e.id.membre = :id")
	Integer findEloMaxById(@Param("id") Integer id);

	@Query("select p from Participation p where :tournoi= p.id.tournoi")
	List<Membre> findByTournoi(@Param("tournoi")Tournoi tournoi);

	@Query("select count(p.id) from Partie p where (p.joueurBlancs = :id) or (p.joueurNoirs = :id)")
	Integer countPartiesById(@Param("id") Integer id);

	@Query("select count(p.id) from Partie p where (p.joueurBlancs = :id and p.resultBlancs = 1) or (p.joueurNoirs =:id and p.resultNoirs = 1) ")
	Integer countVictoires(@Param("id")Integer id);

	@Query("select count(p.id) from Partie p where (p.joueurBlancs = :id and p.resultBlancs = 0.5) or (p.joueurNoirs =:id and p.resultNoirs = 0.5) ")
	Integer countNuls(@Param("id")Integer id);

	@Query("select count(p.id) from Partie p where (p.joueurBlancs = :id and p.resultBlancs = 0) or (p.joueurNoirs =:id and p.resultNoirs = 0) ")
	Integer countDefaites(@Param("id")Integer id);
	
//	Double pourcentageVictoire(Integer id);
	
	@Query("select count(p.id) from Participation p where :id = p.id.participant")
	Integer countTournoi(Integer id);
}

package projetechec.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projetechec.entity.Arbitre;
import projetechec.entity.Niveau;
import projetechec.entity.Tournoi;


public interface ArbitreRepository extends JpaRepository<Arbitre, Integer>{
	
	Optional<Arbitre> findByNomAndPrenom(String nom, String prenom);
	
	List<Arbitre> findByNiveau(Niveau niveau);

	@Query("select a from Arbitre a where :tournoi= a.tournois")
	Optional<Arbitre> findByTournoi(Tournoi tournoi);

	@Query("select count(tournois) from Arbitre")
	Integer countAllTournoiByArbitre();
}

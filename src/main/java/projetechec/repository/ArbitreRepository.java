package projetechec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetechec.entity.Arbitre;
import projetechec.entity.Niveau;
import projetechec.entity.Tournoi;


public interface ArbitreRepository extends JpaRepository<Arbitre, Integer>{
	
	Optional<Arbitre> findByNomAndPrenom(String nom, String prenom);
	
	List<Arbitre> findByNiveau(Niveau niveau);

	Optional<Arbitre> findByTournoi(List<Tournoi> tournois);

	@Query("select count(tournois) from arbitre")
	Integer countAllTournoiByArbitre();
}

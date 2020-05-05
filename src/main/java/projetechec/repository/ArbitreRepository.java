package projetechec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetechec.entity.Arbitre;
import projetechec.entity.Niveau;


public interface ArbitreRepository extends JpaRepository<Arbitre, Integer>{
	
	@Query("select a from arbitre a left join fetch a.nom_arbitre where a.nom_arbitre=:nom"
			+ "select a from arbitre a left join fetch a.prenom_arbitre where a.prenom_arbitre=:prenom")
	Optional<Arbitre> findByNomAndPrenom(@Param("nom") String nom, @Param("prenom") String prenom);
	
	@Query("select a from arbitre a left join fetch a.niveau where a.niveau=:niveau")
	List<Arbitre> findByPrenom(@Param("niveau") Niveau niveau);

	@Query("select a from arbitre a left join fetch a.tournoi where a.tournoi=:tournoi")
	Optional<Arbitre> findByTournoi(@Param("tournoi") String tournoi);

	@Query("select a count(tournois) from arbitre")
	Integer countAllTournoiByArbitre();
}

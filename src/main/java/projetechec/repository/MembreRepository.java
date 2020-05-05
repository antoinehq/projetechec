package projetechec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetechec.entity.Club;
import projetechec.entity.Membre;
import projetechec.entity.Tournoi;

public interface MembreRepository extends JpaRepository<Membre, Integer>{

	Optional<Membre> findByNomAndPrenom(String nom, String prenom);
	
	List<Membre> findByClub(Club club);
	
	List<Membre> findByElo(Integer elo);
	
	@Query("select elo from HistoriqueElo e where e.membre= :id")
	Integer findEloMaxById(@Param("id")Integer id);
	
	@Query()
	List<Membre> findByTournoi(Tournoi tournoi);
	
	Integer countParties(Integer id);
	
	Integer countVictoires(Integer id);
	
	Integer countNuls(Integer id);
	
	Integer countDefaites(Integer id);
	
	Double pourcentageVictoire(Integer id);

	Integer countTournoi(Integer id);
}

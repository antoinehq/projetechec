package projetechec.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetechec.entity.Arbitre;
import projetechec.entity.Cadence;
import projetechec.entity.Club;
import projetechec.entity.Membre;
import projetechec.entity.Participation;
import projetechec.entity.Tournoi;

public interface TournoiRepository extends JpaRepository<Tournoi, Integer> {
	@Query("select t from Tournoi t where t.date=:date")
	List<Tournoi> findByDate(@Param("date") Date date);

	@Query("select t from Tournoi t where t.cadence=:cadence")
	List<Tournoi> findByCadence(@Param("cadence") Cadence cadence);

	@Query("select t from Tournoi t where t.organisateur=:club")
	List<Tournoi> findByClub(@Param("club") Club club);

	@Query("select t from Tournoi t where t.arbitre =:arbitre")
	List<Tournoi> findByArbitre(@Param("arbitre") Arbitre arbitre);

	@Query("select p from Participation p where p.id.participant=:participant")
	List<Tournoi> findByMembre(@Param("participant") Membre participant);

}

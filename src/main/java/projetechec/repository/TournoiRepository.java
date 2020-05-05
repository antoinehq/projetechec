package projetechec.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetechec.entity.Arbitre;
import projetechec.entity.Cadence;
import projetechec.entity.Club;
import projetechec.entity.Participation;
import projetechec.entity.Tournoi;

public interface TournoiRepository extends JpaRepository<Tournoi, Integer> {
	@Query("select t from tournoi t left join fetch t.date_tournoi where t.date_tournoi=:date")
	List<Tournoi> findByDate(@Param("date") Date date);

	@Query("select t from tournoi t left join fetch t.cadence_tournoi where t.cadence_tournoi=:cadence")
	List<Tournoi> findByCadence(@Param("cadence") Cadence cadence);

	@Query("select t from tournoi t left join fetch t.organisateur where t.organisateur=:club")
	List<Tournoi> findByClub(@Param("club") Club club);

	@Query("select t from tournoi t left join fetch t.arbitre_tournoi where t.arbitre_tournoi=:arbitre")
	List<Tournoi> findByArbitre(@Param("arbitre") Arbitre arbitre);

	@Query("select t from tournoi c left join fetch membre where t.participations=:participations")
	List<Tournoi> findByMembre(@Param("participations") Participation participations);

}

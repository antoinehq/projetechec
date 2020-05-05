package projetechec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetechec.entity.Club;

public interface ClubRepository extends JpaRepository<Club, Integer> {
	@Query("select c from club c left join fetch c.pays_club where c.pays_club=:pays")
	List<Club> findByPays(@Param("pays") String pays, Pageable pageable);

	@Query("select c from club c left join fetch c.ville_club where c.ville_club=:ville")
	List<Club> findByVille(@Param("ville") String ville);

	@Query("select c from club c left join fetch c.nom_club where c.nom_club=:nom")
	Optional<Club> findByNom(@Param("nom") String nom);

	@Query("select c count(*) from club")
	Integer countById();

	@Query("select c count(membres) from club")
	Integer countAllMembreByClub();

	@Query("select c count(tournois) from club")
	Integer countAllTournoiByClub();

}

package projetechec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projetechec.entity.ContenuPedagogique;
import projetechec.entity.Livre;
import projetechec.entity.Video;

public interface ContenuPedagogiqueRepository extends JpaRepository<ContenuPedagogique, Integer> {
	Optional<ContenuPedagogique> findByTitre(String titre);

	List<ContenuPedagogique> findByAuteur(String auteur, Pageable pageable);

	@Query("select c from contenu_pedagogique c where type = 'L' ")
	List<Livre> findAllLivre(Pageable pageable);

	@Query("select c from contenu_pedagogique c where type = 'V' ")
	List<Video> findAllVideo(Pageable pageable);

	Integer countById();

	@Query("select c from contenu_pedagogique c where type = 'L' ")
	Integer countByLivre();

	@Query("select c from contenu_pedagogique c where type = 'V' ")
	Integer countByVideo();

}

package projetechec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetechec.entity.Partie;

public interface PartieRepository extends JpaRepository<Partie, Integer> {

	
}

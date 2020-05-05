package projetechec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetechec.entity.Tournoi;

public interface TournoiRepository extends JpaRepository<Tournoi, Integer>{

}

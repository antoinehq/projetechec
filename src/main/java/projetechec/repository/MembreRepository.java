package projetechec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetechec.entity.Membre;

public interface MembreRepository extends JpaRepository<Membre, Integer>{

}

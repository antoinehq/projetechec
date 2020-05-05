package projetechec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetechec.entity.Participation;
import projetechec.entity.ParticipationKey;

public interface ParticipationRepository extends JpaRepository<Participation, ParticipationKey>{

}

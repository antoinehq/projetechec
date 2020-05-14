package projetechec.service;

import java.util.Date;
import java.util.List;

import projetechec.entity.Arbitre;
import projetechec.entity.Cadence;
import projetechec.entity.Club;
import projetechec.entity.Participation;
import projetechec.entity.Tournoi;
import projetechec.repository.TournoiRepository;

public class TournoiService {
	private TournoiRepository tournoiRepository;

	public List<Tournoi> findByDate(Date date) {
		List<Tournoi> list = tournoiRepository.findByDate(date);
		if (list.isEmpty()) {
			return list;
		}
		throw new IllegalArgumentException();
	}

	public List<Tournoi> findByCadence(Cadence cadence) {
		List<Tournoi> list = tournoiRepository.findByCadence(cadence);
		if (list.isEmpty()) {
			return list;
		}
		throw new IllegalArgumentException();
	}

	public List<Tournoi> findByClub(Club club) {
		List<Tournoi> list = tournoiRepository.findByClub(club);
		if (list.isEmpty()) {
			return list;
		}
		throw new IllegalArgumentException();
	}

	public List<Tournoi> findByArbitre(Arbitre arbitre) {
		List<Tournoi> list = tournoiRepository.findByArbitre(arbitre);
		if (list.isEmpty()) {
			return list;
		}
		throw new IllegalArgumentException();
	}

	public List<Tournoi> findByParticipation(Participation participations) {
		List<Tournoi> list = tournoiRepository.findByMembre(participations);
		if (list.isEmpty()) {
			return list;
		}
		throw new IllegalArgumentException();
	}

}

package projetechec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projetechec.entity.Club;
import projetechec.repository.ClubRepository;

@Service
public class ClubService {

	private ClubRepository clubRepository;

	public List<Club> findByPays(String pays) {
		List<Club> list = clubRepository.findByPays(pays);
		if (list.isEmpty()) {
		return list;
		}
		throw new IllegalArgumentException();
	}

	public List<Club> findByVille(String ville) {
		List<Club> list = clubRepository.findByVille(ville);
		if (list.isEmpty()) {
			return list;
		}
		throw new IllegalArgumentException();
	}

	public Club findByNom(String nom) {
		Optional<Club> opt = clubRepository.findByNom(nom);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new IllegalArgumentException();
	}

	public Integer countAllMembreByClub() {
		
		return null;
	}

	public Integer countAllTournoiByClub() {
		return null;
	}
}

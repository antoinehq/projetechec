package projetechec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import projetechec.entity.Club;
import projetechec.entity.Membre;
import projetechec.repository.MembreRepository;

@Service
public class MembreService {

	@Autowired
	private MembreRepository membreRepository;
	
	public Membre findById(Integer id) {
		Optional<Membre> opt= membreRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new IllegalArgumentException();
	}
	
	public Membre findByNomAndPrenom(String nom, String prenom) {
		Optional<Membre> opt= membreRepository.findByNomAndPrenom(nom, prenom);
		if (opt.isPresent() ) {
			return opt.get();
		}
		throw new IllegalArgumentException();
	}
	
	public List<Membre> findByClub(Club club) {
		List<Membre> membres = membreRepository.findByClub(club);
		if (membres.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return membres;
	}
	
	public List<Membre> findByElo(Integer elo) {
		List<Membre> membres = membreRepository.findByElo(elo);
		if (membres.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return membres;
	}
	
	public Integer findEloMaxById(Integer id) {
		List<Membre> membres = membreRepository.findEloMaxById(id);
	}
	
}

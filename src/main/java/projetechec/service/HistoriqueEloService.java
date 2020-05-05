package projetechec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import projetechec.entity.HistoriqueElo;
import projetechec.repository.HistoriqueEloRepository;

public class HistoriqueEloService {

	@Autowired
	private HistoriqueEloRepository historiqueEloRepository;

	public void ajout(HistoriqueElo historiqueElo) {
		historiqueEloRepository.save(historiqueElo);
	}

	public HistoriqueElo miseAJour(HistoriqueElo historiqueElo) {
		Optional<HistoriqueElo> opt = historiqueEloRepository.findById(historiqueElo.getId());
		if (opt.isPresent()) {
			HistoriqueElo historiqueEloEnBase = opt.get();
			historiqueEloEnBase.setElo(historiqueElo.getElo());
			historiqueEloRepository.save(historiqueEloEnBase);
			return historiqueEloEnBase;
		} else {
			return null;
		}
	}

}

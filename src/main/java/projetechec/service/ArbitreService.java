package projetechec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetechec.entity.Arbitre;
import projetechec.repository.ArbitreRepository;

@Service
class ArbitreService {
	
	@Autowired
	private ArbitreRepository arbitreRepository;

	public void ajout(Arbitre arbitre) {
		if (arbitre.getNom().isEmpty()) {
			arbitre.setNom("non indique");
		}
		else if (arbitre.getPrenom().isEmpty()) {
			arbitre.setPrenom("non indique");
		}
		else if (arbitre.getEmail().isEmpty()) {
			arbitre.setEmail("non indique");
		}
//		else if (arbitre.getNiveau().isEmpty()) {
//			arbitre.setNiveau("non defini");
//		}		
		arbitreRepository.save(arbitre);
	}

	public Arbitre miseAjour(Arbitre arbitre) {
		Optional<Arbitre> opt = arbitreRepository.findById(arbitre.getId());
		if (opt.isPresent()) {
			Arbitre arbitreEnBase = opt.get();
			if (arbitre.getNom() != null) {
				arbitreEnBase.setNom(arbitre.getNom());
			}
			else if (arbitre.getPrenom() != null) {
				arbitreEnBase.setPrenom(arbitre.getPrenom());
			}
			else if (arbitre.getEmail() != null) {
				arbitreEnBase.setEmail(arbitre.getEmail());
			}
			arbitreEnBase.setNiveau(arbitre.getNiveau());
			arbitreRepository.save(arbitreEnBase);
			return arbitreEnBase;
		} else {
			// arbitreRepository.save(arbitre);// on insert
			return null;
		}
		// throw new NoArbitreFoundException();

	}

	public Arbitre recherche(Integer id) {
		Optional<Arbitre> opt=arbitreRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new IllegalArgumentException();
	}

}

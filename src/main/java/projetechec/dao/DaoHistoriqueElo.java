package projetechec.dao;

import java.util.List;
import java.util.Optional;

import projetechec.entity.HistoriqueElo;
import projetechec.entity.HistoriqueEloKey;



public interface DaoHistoriqueElo extends DaoGeneric<HistoriqueElo,Integer> {
	List<HistoriqueElo> findById(Integer id);

	void deleteByKey(HistoriqueEloKey key);

	Optional<HistoriqueElo> findByKey(HistoriqueEloKey key);
}

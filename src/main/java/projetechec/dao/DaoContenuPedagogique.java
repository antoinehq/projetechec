package projetechec.dao;

import java.util.List;

import projetechec.entity.ContenuPedagogique;
import projetechec.entity.Livre;
import projetechec.entity.Video;

public interface DaoContenuPedagogique extends DaoGeneric<ContenuPedagogique, Integer> {
	List<Livre> findAllLivres();

	List<Video> findAllVideos();
}

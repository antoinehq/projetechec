package projetechec;

import projetechec.context.Context;
import projetechec.dao.DaoTournoi;
import projetechec.dao.DaoTournoiFactory;
import projetechec.entity.Tournoi;

public class TestTournoi {

	public static void main(String[] args) {
		DaoTournoi daoTournoi = DaoTournoiFactory.getInstance();
		Tournoi grenke = new Tournoi();
		
		daoTournoi.insert(grenke);
		
		
		Context.destroy();
	}

}

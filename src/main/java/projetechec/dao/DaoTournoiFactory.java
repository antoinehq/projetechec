package projetechec.dao;

public class DaoTournoiFactory {
	private static DaoTournoi singleton = null;

	public static DaoTournoi getInstance() {
		if (singleton == null) {
			singleton = new DaoTournoiImpl();
		}
		return singleton;
	}

	private DaoTournoiFactory() {

	}
}

package projetechec.dao;

public class DaoClubFactory {
	private static DaoClub singleton = null;

	public static DaoClub getInstance() {
		if (singleton == null) {
			singleton = new DaoClubImpl();
		}
		return singleton;
	}

	private DaoClubFactory() {

	}
}

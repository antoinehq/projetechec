package projetechec.dao;

public class DaoMembreFactory {
	private static DaoMembre singleton = null;

	public static DaoMembre getInstance() {
		if (singleton == null) {
			singleton = new DaoMembreImpl();
		}
		return singleton;
	}

	private DaoMembreFactory() {

	}
}

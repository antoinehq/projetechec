package projetechec.dao;

public class DaoMembreFactory {
	private static DaoMembre singleton = null;

	public static DaoMembre getInstance() {
		if (singleton == null) {
			singleton = new DaoMembreXXXImpl();
		}
		return singleton;
	}

	private DaoMembreFactory() {

	}
}

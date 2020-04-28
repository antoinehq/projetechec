package projetechec.dao;

public class DaoArbitreFactory {
	private static DaoArbitre singleton = null;

	public static DaoArbitre getInstance() {
		if (singleton == null) {
			singleton = new DaoArbitreJpaImpl();
		}
		return singleton;
	}

	private DaoArbitreFactory() {

	}
}

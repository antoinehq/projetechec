package projetechec.dao;

public class DaoContenuPedagogiqueFactory {
	private static DaoContenuPedagogique singleton = null;

	public static DaoContenuPedagogique getInstance() {
		if (singleton == null) {
			singleton = new DaoContenuPedagogiqueImpl();
		}
		return singleton;
	}

	private DaoContenuPedagogiqueFactory() {

	}
}

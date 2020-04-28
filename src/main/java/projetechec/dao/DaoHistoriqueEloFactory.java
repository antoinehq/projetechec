package projetechec.dao;

public class DaoHistoriqueEloFactory {
	private static DaoHistoriqueElo singleton = null;
	
	public static DaoHistoriqueElo getInstance() {
		if (singleton == null) {
			singleton = new DaoHistoriqueEloImpl();
		}
		return singleton;
	}
	
	private DaoHistoriqueEloFactory() {
		
	}
}

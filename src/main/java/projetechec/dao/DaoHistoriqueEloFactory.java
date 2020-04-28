package projetechec.dao;

public class DaoHistoriqueEloFactory {
	private static DaoHistoriqueElo daoHistoriqueElo = null;

	public static DaoHistoriqueElo getInstance() {
		if (daoHistoriqueElo == null) {
			daoHistoriqueElo = new DaoHistoriqueEloImpl();
		}
		return daoHistoriqueElo;
	}
}


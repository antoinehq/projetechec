package projetechec.entity;

public class HistoriqueEloKey {

	
	// attributs
	private HistoriqueElo historiqueElo;

	
	// constructors
	public HistoriqueEloKey(HistoriqueElo historiqueElo) {
		this.setHistoriqueElo(historiqueElo);
	}

	public HistoriqueEloKey() {
	}


	// getters and setters
	
	public HistoriqueElo getHistoriqueElo() {
		return historiqueElo;
	}

	public void setHistoriqueElo(HistoriqueElo historiqueElo) {
		this.historiqueElo = historiqueElo;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((historiqueElo == null) ? 0 : historiqueElo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoriqueEloKey other = (HistoriqueEloKey) obj;
		if (historiqueElo == null) {
			if (other.historiqueElo != null)
				return false;
		} else if (!historiqueElo.equals(other.historiqueElo))
			return false;
		return true;
	}

}

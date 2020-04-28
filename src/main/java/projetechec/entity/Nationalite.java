package projetechec.entity;

public enum Nationalite {
	
	FR("france"), DE("allemagne");

	private String pays;

	private Nationalite(String pays) {
		this.pays = pays;
	}

	public String getPays() {
		return pays;
	}
}

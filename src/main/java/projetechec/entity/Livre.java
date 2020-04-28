package projetechec.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("L")
public class Livre extends ContenuPedagogique {
	@Column(name = "isbn", length = 15)
	private String isbn;

	public Livre() {
		super();
	}

	public Livre(String titre, Double prix) {
		super(titre, prix);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}

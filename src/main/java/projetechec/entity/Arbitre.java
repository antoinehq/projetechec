package projetechec.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "arbitre")
@SequenceGenerator(name = "seqArbitre", sequenceName = "seq_arbitre", initialValue = 100, allocationSize = 1)
public class Arbitre {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqArbitre")
	@Column(name = "id_arbitre")
	private Integer id;
	@Column(name = "prenom_arbitre", length = 100)
	private String prenom;
	@Column(name = "nom_arbitre", length = 100)
	private String nom;
	@Column(name = "niveau", length = 5)
	@Enumerated(EnumType.STRING)
	private Niveau niveau;
	@OneToMany(mappedBy = "arbitre")
	private List<Tournoi> tournois;

	public Arbitre() {
	}

	public Arbitre(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}

	public Arbitre(Integer id, String prenom, String nom, Niveau niveau) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.niveau = niveau;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public List<Tournoi> getTournois() {
		return tournois;
	}

	public void setTournois(List<Tournoi> tournois) {
		this.tournois = tournois;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Arbitre other = (Arbitre) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

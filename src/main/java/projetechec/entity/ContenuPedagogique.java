package projetechec.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "contenu_pedagogique")
@SequenceGenerator(name = "seqContenuPedagogique", sequenceName = "seq_contenu_pedagogique", initialValue = 100, allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 1)
public class ContenuPedagogique {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqContenuPedagogique")
	@Column(name = "id_contenu_pedagogique")
	private Integer id;
	@Column(name = "titre", length = 150, nullable = false)
	private String titre;
	@Column(name = "prix")
	private Double prix;
	@ManyToOne
	@JoinColumn(name = "acheteur", foreignKey = @ForeignKey(name = "contenu_pedagogique_acheteur_fk"))
	private Membre acheteur;

	public ContenuPedagogique() {
	}

	public ContenuPedagogique(String titre, Double prix) {
		this.titre = titre;
		this.prix = prix;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Membre getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(Membre acheteur) {
		this.acheteur = acheteur;
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
		ContenuPedagogique other = (ContenuPedagogique) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

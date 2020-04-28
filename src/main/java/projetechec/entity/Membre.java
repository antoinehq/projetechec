package projetechec.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "membre")
@SequenceGenerator(name = "seqMembre", sequenceName = "seq_membre", initialValue = 100, allocationSize = 1)
public class Membre {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMembre")
	@Column(name = "id_membre", length = 10)
	private Integer id;
	@Column(name = "prenom", length = 40, nullable = false)
	private String prenom;
	@Column(name = "prenom", length = 40, nullable = false)
	private String nom;
	@Column(name = "email", length = 40, nullable = false)
	private String email;
	@Column(name = "elo", length = 5)
	private Integer elo;
	@Column(name = "civilite", length = 4)
	@Enumerated(EnumType.STRING)
	private Civilite civilite;
	@Version
	private int version;
	@Column(name = "nationalite", length = 2)
	@Enumerated(EnumType.STRING)
	private Nationalite nationalite;
	@Embedded
	private Adresse adresse;
	@OneToMany
	private List<Partie> partie;
	@ManyToOne
	@JoinColumn(name = "club", foreignKey = @ForeignKey(name = "membre_club_fk"))
	private Club club;
	@OneToMany(mappedBy = "acheteur")
	private List<ContenuPedagogique> contenuPedagogique;
	@OneToMany(mappedBy = "id.membre")
	private List<HistoriqueElo> historiqueElo;
	@OneToMany(mappedBy = "id.participant")
	private List<Participation> participations;

	public Membre() {
	}

	public Membre(String prenom, String nom, String email, Integer elo) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.elo = elo;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getElo() {
		return elo;
	}

	public void setElo(Integer elo) {
		this.elo = elo;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Nationalite getNationalite() {
		return nationalite;
	}

	public void setNationalite(Nationalite nationalite) {
		this.nationalite = nationalite;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public void setPartie(List<Partie> partie) {
		this.partie = partie;
	}

	public void setContenuPedagogique(List<ContenuPedagogique> contenuPedagogique) {
		this.contenuPedagogique = contenuPedagogique;
	}

	public void setHistoriqueElo(List<HistoriqueElo> historiqueElo) {
		this.historiqueElo = historiqueElo;
	}

	public List<Partie> getPartie() {
		return partie;
	}

	public List<ContenuPedagogique> getContenuPedagogique() {
		return contenuPedagogique;
	}

	public List<HistoriqueElo> getHistoriqueElo() {
		return historiqueElo;
	}

	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
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
		Membre other = (Membre) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
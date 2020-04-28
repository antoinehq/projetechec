package projetechec.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tournoi")
@SequenceGenerator(name = "seqTournoi", sequenceName = "seq_tournoi", initialValue = 100, allocationSize = 1)
public class Tournoi {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTournoi")
	@Column(name = "id_tournoi")
	private Integer id;
	@Column(name = "date_tournoi")
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name = "nb_rondes_tournoi")
	private Integer nbRondes;
	@Column(name = "salle_tournoi", length = 150)
	private String salle;
	@Column(name = "frais_inscription_tournoi")
	private Integer fraisInscription;
	@Column(name = "prix_tournoi")
	private Integer prix;
	@Column(name = "cadence", length = 50)
	@Enumerated(EnumType.STRING)
	private Cadence cadence;
	@OneToOne
	@JoinColumn(name = "arbitre_tournoi", foreignKey = @ForeignKey(name="tournoi_arbitre_fk"))
	private Arbitre arbitre;
	@ManyToOne
	@JoinColumn(name = "organisateur", foreignKey = @ForeignKey(name = "tournoi_club_fk"))
	private Club club;
	@OneToMany(mappedBy = "partie")
	private List<Partie> partie;
	@OneToMany(mappedBy = "participation")
	private List<Participation> participation;

	public Tournoi() {
	}

	public Tournoi(Date date, Integer nbRondes, String salle, Cadence cadence) {
		this.date = date;
		this.nbRondes = nbRondes;
		this.salle = salle;
		this.cadence = cadence;
	}

	public Tournoi(Integer id, Date date, Integer nbRondes, String salle, Integer fraisInscription, Integer prix,
			Cadence cadence, Arbitre arbitre) {
		this.id = id;
		this.date = date;
		this.nbRondes = nbRondes;
		this.salle = salle;
		this.fraisInscription = fraisInscription;
		this.prix = prix;
		this.cadence = cadence;
		this.arbitre = arbitre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getNbRondes() {
		return nbRondes;
	}

	public void setNbRondes(Integer nbRondes) {
		this.nbRondes = nbRondes;
	}

	public String getSalle() {
		return salle;
	}

	public void setSalle(String salle) {
		this.salle = salle;
	}

	public Integer getFraisInscription() {
		return fraisInscription;
	}

	public void setFraisInscription(Integer fraisInscription) {
		this.fraisInscription = fraisInscription;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public Cadence getCadence() {
		return cadence;
	}

	public void setCadence(Cadence cadence) {
		this.cadence = cadence;
	}

	public Arbitre getArbitre() {
		return arbitre;
	}

	public void setArbitre(Arbitre arbitre) {
		this.arbitre = arbitre;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public List<Partie> getPartie() {
		return partie;
	}

	public void setPartie(List<Partie> partie) {
		this.partie = partie;
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
		Tournoi other = (Tournoi) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

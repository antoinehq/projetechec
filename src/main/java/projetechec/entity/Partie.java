package projetechec.entity;

import java.util.Date;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "partie")
@SequenceGenerator(name = "seqPartie", sequenceName = "seq_partie", allocationSize = 1, initialValue = 100)

public class Partie {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPartie")
	@Column(name = "id_partie")
	private Integer id;
//	@ManyToOne
//	@JoinColumn(name = "", foreignKey = @ForeignKey(name = ""))
//	private Membre membre;
	@Column(name = "membre_blanc_partie", length = 50, nullable = false)
	private String membre_blanc;
	@Column(name = "membre_noir_partie", length = 50, nullable = false)
	private String membre_noir;
	@Column(name = "result_blanc_partie", length = 5, nullable = false)
	private Double result_blanc;
	@Column(name = "result_noir_partie", length = 5, nullable = false)
	private Double result_noir;
	@Column(name = "date_partie")
	@Temporal(TemporalType.DATE)
	private Date datePartie;
//	@OneToMany(mappedBy = "partie")
//	private Set<Membre> membres = new HashSet<>();


	public Partie() {

	}

	
	// getters & setters
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getMembre_blanc() {
		return membre_blanc;
	}


	public void setMembre_blanc(String membre_blanc) {
		this.membre_blanc = membre_blanc;
	}


	public String getMembre_noir() {
		return membre_noir;
	}


	public void setMembre_noir(String membre_noir) {
		this.membre_noir = membre_noir;
	}


	public Double getResult_blanc() {
		return result_blanc;
	}


	public void setResult_blanc(Double result_blanc) {
		this.result_blanc = result_blanc;
	}


	public Double getResult_noir() {
		return result_noir;
	}


	public void setResult_noir(Double result_noir) {
		this.result_noir = result_noir;
	}


	public Date getDatePartie() {
		return datePartie;
	}


	public void setDatePartie(Date datePartie) {
		this.datePartie = datePartie;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datePartie == null) ? 0 : datePartie.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((membre_blanc == null) ? 0 : membre_blanc.hashCode());
		result = prime * result + ((membre_noir == null) ? 0 : membre_noir.hashCode());
		result = prime * result + ((result_blanc == null) ? 0 : result_blanc.hashCode());
		result = prime * result + ((result_noir == null) ? 0 : result_noir.hashCode());
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
		Partie other = (Partie) obj;
		if (datePartie == null) {
			if (other.datePartie != null)
				return false;
		} else if (!datePartie.equals(other.datePartie))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (membre_blanc == null) {
			if (other.membre_blanc != null)
				return false;
		} else if (!membre_blanc.equals(other.membre_blanc))
			return false;
		if (membre_noir == null) {
			if (other.membre_noir != null)
				return false;
		} else if (!membre_noir.equals(other.membre_noir))
			return false;
		if (result_blanc == null) {
			if (other.result_blanc != null)
				return false;
		} else if (!result_blanc.equals(other.result_blanc))
			return false;
		if (result_noir == null) {
			if (other.result_noir != null)
				return false;
		} else if (!result_noir.equals(other.result_noir))
			return false;
		return true;
	}
	
}

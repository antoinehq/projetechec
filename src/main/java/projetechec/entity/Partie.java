package projetechec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "game")
@SequenceGenerator(name = "seqGame", sequenceName = "seq_game", allocationSize = 1, initialValue = 100)
@NamedQueries({ @NamedQuery(query = "select f from Game f", name = "Game.findAll"),
		@NamedQuery(query = "select f from Game f where f.nom = :nom", name = "Game.findByNom"),
		@NamedQuery(name = "Game.findByNomLike", query = "select f from Game f where f.nom like :nom "),
		@NamedQuery(name = "Game.findAllWithStagiaire", 
		query = "select distinct f from Game f left join fetch  f.stagiaires left join fetch f.salle"),
		@NamedQuery(name = "Game.findByKeyWithStagiaires", 
		query = "select distinct f from Game f left join fetch  f.stagiaires left join fetch f.salle where f.id = :id") })


public class Partie {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGame")
	@Column(name = "id_game")
	private Integer id;
	@Column(name = "result_game", length = 100, nullable = false)
	private Double nom;
	@Column(name = "date_game")
	@Temporal(TemporalType.DATE)
	private Date dateGame;
	@OneToMany(mappedBy = "game")
	private Set<Stagiaire> stagiaires = new HashSet<>();
	@OneToOne()
	@JoinColumn(name = "room", foreignKey = @ForeignKey(name = "game_room_fk"))
	private Salle salle;

	public Game() {

	}
	
	
	

}

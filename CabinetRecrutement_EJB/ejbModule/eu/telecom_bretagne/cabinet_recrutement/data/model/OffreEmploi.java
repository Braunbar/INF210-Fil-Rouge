package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the offre_emploi database table.
 * 
 */
@Entity
@Table(name="offre_emploi")
@NamedQuery(name="OffreEmploi.findAll", query="SELECT o FROM OffreEmploi o")
public class OffreEmploi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OFFRE_EMPLOI_ID_GENERATOR", sequenceName="OFFRE_EMPLOI_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OFFRE_EMPLOI_ID_GENERATOR")
	private Integer id;

	@Column(name="date_depot")
	private Timestamp dateDepot;

	@Column(name="descriptif_mission")
	private String descriptifMission;

	@Column(name="profil_recherche")
	private String profilRecherche;

	//bi-directional many-to-one association to MessageOffreDEmploi
	@OneToMany(mappedBy="offreEmploi")
	private Set<MessageOffreDEmploi> messageOffreDEmplois;

	//bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name="id_entreprise")
	private Entreprise entreprise;

	//bi-directional many-to-one association to NiveauQualification
	@ManyToOne
	@JoinColumn(name="id_niveau_qualification")
	private NiveauQualification niveauQualification;

	//bi-directional many-to-many association to SecteurActivite
	@ManyToMany
	@JoinTable(
		name="offre_emploi_secteur_activite"
		, joinColumns={
			@JoinColumn(name="id_offre_emploi")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_secteur_activite")
			}
		)
	private Set<SecteurActivite> secteurActivites;

	public OffreEmploi() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDateDepot() {
		return this.dateDepot;
	}

	public void setDateDepot(Timestamp dateDepot) {
		this.dateDepot = dateDepot;
	}

	public String getDescriptifMission() {
		return this.descriptifMission;
	}

	public void setDescriptifMission(String descriptifMission) {
		this.descriptifMission = descriptifMission;
	}

	public String getProfilRecherche() {
		return this.profilRecherche;
	}

	public void setProfilRecherche(String profilRecherche) {
		this.profilRecherche = profilRecherche;
	}

	public Set<MessageOffreDEmploi> getMessageOffreDEmplois() {
		return this.messageOffreDEmplois;
	}

	public void setMessageOffreDEmplois(Set<MessageOffreDEmploi> messageOffreDEmplois) {
		this.messageOffreDEmplois = messageOffreDEmplois;
	}

	public MessageOffreDEmploi addMessageOffreDEmploi(MessageOffreDEmploi messageOffreDEmploi) {
		getMessageOffreDEmplois().add(messageOffreDEmploi);
		messageOffreDEmploi.setOffreEmploi(this);

		return messageOffreDEmploi;
	}

	public MessageOffreDEmploi removeMessageOffreDEmploi(MessageOffreDEmploi messageOffreDEmploi) {
		getMessageOffreDEmplois().remove(messageOffreDEmploi);
		messageOffreDEmploi.setOffreEmploi(null);

		return messageOffreDEmploi;
	}

	public Entreprise getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public NiveauQualification getNiveauQualification() {
		return this.niveauQualification;
	}

	public void setNiveauQualification(NiveauQualification niveauQualification) {
		this.niveauQualification = niveauQualification;
	}

	public Set<SecteurActivite> getSecteurActivites() {
		return this.secteurActivites;
	}

	public void setSecteurActivites(Set<SecteurActivite> secteurActivites) {
		this.secteurActivites = secteurActivites;
	}

}
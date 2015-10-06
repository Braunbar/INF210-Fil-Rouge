package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the message_offre_d_emploi database table.
 * 
 */
@Entity
@Table(name="message_offre_d_emploi")
@NamedQuery(name="MessageOffreDEmploi.findAll", query="SELECT m FROM MessageOffreDEmploi m")
public class MessageOffreDEmploi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MESSAGE_OFFRE_D_EMPLOI_ID_GENERATOR", sequenceName="MESSAGE_OFFRE_D_EMPLOI_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MESSAGE_OFFRE_D_EMPLOI_ID_GENERATOR")
	private Integer id;

	@Column(name="corps_message")
	private String corpsMessage;

	@Column(name="date_envoi")
	private Timestamp dateEnvoi;

	//bi-directional many-to-one association to OffreEmploi
	@ManyToOne
	@JoinColumn(name="id_offre_emploi")
	private OffreEmploi offreEmploi;

	public MessageOffreDEmploi() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorpsMessage() {
		return this.corpsMessage;
	}

	public void setCorpsMessage(String corpsMessage) {
		this.corpsMessage = corpsMessage;
	}

	public Timestamp getDateEnvoi() {
		return this.dateEnvoi;
	}

	public void setDateEnvoi(Timestamp dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public OffreEmploi getOffreEmploi() {
		return this.offreEmploi;
	}

	public void setOffreEmploi(OffreEmploi offreEmploi) {
		this.offreEmploi = offreEmploi;
	}

}
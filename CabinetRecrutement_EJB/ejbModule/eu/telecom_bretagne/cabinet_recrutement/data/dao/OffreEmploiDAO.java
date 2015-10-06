package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

/**
 * Session Bean implementation class OffreEmploiDAO
 * @author AGirard MCorre
 */
@Stateless
@LocalBean
public class OffreEmploiDAO
{
	//-----------------------------------------------------------------------------
	/**
	 * Référence vers le gestionnaire de persistance.
	 */
	@PersistenceContext
	EntityManager entityManager;
	//-----------------------------------------------------------------------------
	/**
	 * Default constructor.
	 */
	public OffreEmploiDAO()
	{
		// TODO Auto-generated constructor stub
	}
	//-----------------------------------------------------------------------------
	public OffreEmploi findById(Integer id)
	{
		return entityManager.find(OffreEmploi.class, id);
	}
	//----------------------------------------------------------------------------
  public List<OffreEmploi> findAll()
	{
		Query query = entityManager.createQuery("select offreEmploi from OffreEmploi offreEmploi order by offreEmploi.id");
		List l = query.getResultList();

		return (List<OffreEmploi>) l;
	}
	//-----------------------------------------------------------------------------
  
  public OffreEmploi persist (OffreEmploi offreEmploi) {
	  entityManager.persist(offreEmploi);	 
	  return findById(offreEmploi.getId());
  }
  
  public OffreEmploi update (OffreEmploi offreEmploi) {
	  return entityManager.merge(offreEmploi);
  }
  
  public void remove (OffreEmploi offreEmploi) {
	  entityManager.remove(offreEmploi);
  }
  
  public List<OffreEmploi> findAllBySecNiv(int secteur, int  niveau)
	{
		Query query = entityManager.createQuery("select offre from OffreEmploi offre "
				+ "JOIN offre.secteurActivites secteur  "
				+ "WHERE offre.niveauQualification.id = :niveau AND secteur.id = :secteur "
						+ "order by offre.id");
		query.setParameter("niveau", niveau);
		query.setParameter("secteur", secteur);
		List l = query.getResultList();

		return (List<OffreEmploi>) l;
	} 
  public List<OffreEmploi> findAllByEnt(int entreprise)
	{
		
		Query query = entityManager.createQuery("select offre from OffreEmploi offre "
				+ "WHERE offre.entreprise.id = :entreprise "
						+ "order by offre.id");
		query.setParameter("entreprise", entreprise);
		List l = query.getResultList();

		return (List<OffreEmploi>) l;
	} 
}

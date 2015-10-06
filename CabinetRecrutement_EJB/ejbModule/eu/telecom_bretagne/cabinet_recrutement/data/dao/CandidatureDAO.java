package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

@Stateless
@LocalBean
public class CandidatureDAO {
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
	public CandidatureDAO()
	{
		// TODO Auto-generated constructor stub
	}
	//-----------------------------------------------------------------------------
	public Candidature findById(Integer id)
	{
		return entityManager.find(Candidature.class, id);
	}
	//----------------------------------------------------------------------------
  public List<Candidature> findAll()
	{
		Query query = entityManager.createQuery("select candidature from Candidature candidature order by candidature.id");
		List l = query.getResultList();

		return (List<Candidature>) l;
	}
	//-----------------------------------------------------------------------------
  
  public Candidature persist (Candidature candidature) {
	  entityManager.persist(candidature);	 
	  return findById(candidature.getId());
  }
  
  public Candidature update (Candidature candidature) {
	  return entityManager.merge(candidature);
  }
  
  public void remove (Candidature candidature) {
	  entityManager.remove(candidature);
  }
  public List<Candidature> findAllBy(int secteur, int niveau)
	{
		Query query = entityManager.createQuery("select candidature from Candidature candidature "
				+ "JOIN candidature.secteurActivites secteur  "
				+ "WHERE candidature.niveauQualification.id = :niveau AND secteur.id = :secteur "
						+ "order by candidature.id");
		query.setParameter("niveau", niveau);
		query.setParameter("secteur", secteur);
		List l = query.getResultList();

		return (List<Candidature>) l;
	} 
}

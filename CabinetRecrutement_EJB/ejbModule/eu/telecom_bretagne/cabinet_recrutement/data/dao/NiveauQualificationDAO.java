package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;

/**
 * Session Bean implementation class NiveauQualificationDAO
 * @author AGirard MCorre
 */
@Stateless
@LocalBean
public class NiveauQualificationDAO
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
	public NiveauQualificationDAO()
	{
		// TODO Auto-generated constructor stub
	}
	//-----------------------------------------------------------------------------
	public NiveauQualification findById(Integer id)
	{
		return entityManager.find(NiveauQualification.class, id);
	}
	//----------------------------------------------------------------------------
  public List<NiveauQualification> findAll()
	{
		Query query = entityManager.createQuery("select niveauQualification from NiveauQualification niveauQualification order by niveauQualification.id");
		List l = query.getResultList();

		return (List<NiveauQualification>) l;
	}
	//-----------------------------------------------------------------------------
  
  public NiveauQualification persist (NiveauQualification niveauQualification) {
	  entityManager.persist(niveauQualification);	 
	  return findById(niveauQualification.getId());
  }
  /*
  public NiveauQualification update (NiveauQualification niveauQualification) {
	  return entityManager.merge(niveauQualification);
  }
  */
  /*
  public void remove (NiveauQualification niveauQualification) {
	  entityManager.remove(niveauQualification);
  }
  */
}

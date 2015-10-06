package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageOffreDEmploi;

/**
 * Session Bean implementation class MessageOffreDEmploiDAO
 * @author AGirard MCorre
 */
@Stateless
@LocalBean
public class MessageOffreDEmploiDAO
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
	public MessageOffreDEmploiDAO()
	{
		// TODO Auto-generated constructor stub
	}
	//-----------------------------------------------------------------------------
	public MessageOffreDEmploi findById(Integer id)
	{
		return entityManager.find(MessageOffreDEmploi.class, id);
	}
	//----------------------------------------------------------------------------
  public List<MessageOffreDEmploi> findAll()
	{
		Query query = entityManager.createQuery("select messageOffreDEmploi from MessageOffreDEmploi messageOffreDEmploi order by messageOffreDEmploi.id");
		List l = query.getResultList();

		return (List<MessageOffreDEmploi>) l;
	}
	//-----------------------------------------------------------------------------
  
  public MessageOffreDEmploi persist (MessageOffreDEmploi messageOffreDEmploi) {
	  entityManager.persist(messageOffreDEmploi);	 
	  return findById(messageOffreDEmploi.getId());
  }
  
  public MessageOffreDEmploi update (MessageOffreDEmploi messageOffreDEmploi) {
	  return entityManager.merge(messageOffreDEmploi);
  }
  
  public void remove (MessageOffreDEmploi messageOffreDEmploi) {
	  entityManager.remove(messageOffreDEmploi);
  }
}

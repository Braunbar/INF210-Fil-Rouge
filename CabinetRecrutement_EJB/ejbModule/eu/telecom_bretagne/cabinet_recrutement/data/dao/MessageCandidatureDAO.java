package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.MessageCandidature;

/**
 * Session Bean implementation class MessageCandidature
 * @author AGirard MCorre
 */
@Stateless
@LocalBean
public class MessageCandidatureDAO {
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
	public MessageCandidatureDAO()
	{
		// TODO Auto-generated constructor stub
	}
	//-----------------------------------------------------------------------------
	public MessageCandidature findById(Integer id)
	{
		return entityManager.find(MessageCandidature.class, id);
	}
	//----------------------------------------------------------------------------
  public List<MessageCandidature> findAll()
	{
		Query query = entityManager.createQuery("select messageCandidature from MessageCandidature messageCandidature order by messageCandidature.id");
		List l = query.getResultList();

		return (List<MessageCandidature>) l;
	}
	//-----------------------------------------------------------------------------
  
  public MessageCandidature persist (MessageCandidature messageCandidature) {
	  entityManager.persist(messageCandidature);	 
	  return findById(messageCandidature.getId());
  }
  
  public MessageCandidature update (MessageCandidature messageCandidature) {
	  return entityManager.merge(messageCandidature);
  }
  
  public void remove (MessageCandidature messageCandidature) {
	  entityManager.remove(messageCandidature);
  }
}

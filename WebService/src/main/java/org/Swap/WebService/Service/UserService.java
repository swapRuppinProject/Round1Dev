package org.Swap.WebService.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.Swap.WebService.Model.User;



public class UserService {
	
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private static final Logger logger = Logger.getLogger(UserService.class);
	
	/**
	 *This function is initalizing an entity factory then creating an entity manager and starting transection.
	 */
	private void EntityManagerInitializer()
	{
		try {
		logger.debug("Trying to create Entity Manager Factory...");
		emf = Persistence.createEntityManagerFactory("swap");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		logger.info("Entity manager factory created successfully.");
		}catch(Exception e)
		{
			logger.error("Error while creating entity manager factory, error: ",e);		}
	}
	
	/**
	 *This function is destroying an entity manager and entity manager factory.
	 */
	private void EntityManagerDestroyer()
	{
		try {
		logger.debug("Trying to destroy the Entity Manager Factory...");
		em.getTransaction().commit();
		em.close();
		emf.close();
		logger.info("Entity manager factory is closed.");
		}catch(Exception e)
		{
			logger.error("Error while closing entity manager factory, error: ",e);		
		}
	}
	
	/**
	 *This function is querying the database selecting all users.
	 *@return List of all the users from the database.
	 */
	public List<User> getAllUsers()
	{
		try {
			logger.debug("Starting to get all users with no param.");
			EntityManagerInitializer();
			Query query = em.createNativeQuery("SELECT user_name,password FROM users");
			List<User> users = em.createQuery("SELECT u FROM users u").getResultList();
			EntityManagerDestroyer();
			logger.info("Success, got all user, no param was used.");
			return new ArrayList<User>(users);
		}catch(Exception e)
		{
			logger.error("Cant get users, error: ",e);
			e.printStackTrace();
		}
		return null;
	}
	
}

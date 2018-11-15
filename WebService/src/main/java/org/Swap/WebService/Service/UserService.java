package org.Swap.WebService.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;

import antlr.ParserSharedInputState;

import org.Swap.WebService.Model.User;
import org.hibernate.exception.SQLGrammarException;



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
			logger.info("Entity manager factory created successfully.");
		}catch(Exception e)
		{
			logger.error("Error while creating entity manager factory, error: ",e);		
		}
	}

	/**
	 *This function is destroying an entity manager and entity manager factory.
	 */
	private void EntityManagerDestroyer()
	{
		try {
			logger.debug("Trying to destroy the Entity Manager Factory...");
			if(em.isOpen())
			{
				em.close();
			}
			if(emf.isOpen())
			{
				emf.close();
			}
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
			//Query query = em.createNativeQuery("SELECT user_name,password FROM users");
			try {
				List<User> users = em.createQuery("SELECT u FROM User u").getResultList();
				logger.info("Success, got all user, no param was used.");
				return new ArrayList<User>(users);
			}
			catch(PersistenceException e)
			{
				if(e.getCause().getCause().getMessage().contains("ERROR: relation \"users\" does not exist"))
				{
					logger.info("No users in the database.");
				}
				else
				{
					logger.error("Error while getting users from database, error: ", e);
				}
			}
		}catch(Exception e)
		{
			logger.error("Cant get users, error: ",e);
		}finally
		{
			EntityManagerDestroyer();
		}
		return null;
	}
	
	/**
	 *This function is querying the database selecting all users.
	 *@return List of all the users from the database.
	 */
	public User getUser(String userName,String password)
	{
		try {
			logger.debug("Validating the user info...");
			EntityManagerInitializer();
			try {
				String query = String.format("SELECT u FROM User u WHERE u.user_name=%s AND u.password=%s",userName,password);
				User user = (User) em.createQuery(query).getSingleResult();
				logger.info("Success, the user can login.");
				return user;
			}
			catch(PersistenceException e)
			{
				if(e.getCause().getCause().getMessage().contains("ERROR: relation \"users\" does not exist"))
				{
					logger.info("No users in the database.");
				}
				else
				{
					logger.error("Error while getting users from database, error: ", e);
				}
			}
		}catch(Exception e)
		{
			logger.error("Cant get users, error: ",e);
		}finally
		{
			EntityManagerDestroyer();
		}
		return null;
	}
	
	/**
	 *This function adding a new user to the database.
	 *
	 *@param user the new user to be added.
	 *@return The new user.
	 */
	public User addUser(User user)	
	{	
		logger.debug("Stating to add the new user...");
		if(user == null)
		{
			logger.warn("The user provided is null");
			return null;
		}
		else {
			EntityManagerInitializer();
			em.getTransaction().begin();
			try {
				em.persist(user);
				logger.info("Success, user created.");
			}catch(Exception e)
			{
				logger.error("Cant create user, error: ",e);
			}
			em.getTransaction().commit();
			EntityManagerDestroyer();
			return user;
		}
	}

}

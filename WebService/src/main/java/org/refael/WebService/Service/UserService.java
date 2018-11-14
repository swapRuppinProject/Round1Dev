package org.refael.WebService.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.refael.WebService.Model.User;



public class UserService {
	public List<User> getAllUsers()
	{
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("swap");
			emf = Persistence.createEntityManagerFactory("swap");
			EntityManager em = emf.createEntityManager();
			
			

			em.getTransaction().begin();
			Query query = em.createNativeQuery("SELECT user_name,password FROM users");
			ArrayList<User> users = (ArrayList<User>) query.getResultList();
			em.getTransaction().commit();
			em.close();
			emf.close();
			return new ArrayList<User>(users);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}

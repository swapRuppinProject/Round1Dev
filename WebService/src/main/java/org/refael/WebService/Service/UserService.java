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
			ArrayList<Object> users = (ArrayList<Object>) query.getResultList();
			em.getTransaction().commit();
			em.close();
			emf.close();
			List<User> newUsers = new ArrayList<>();
			for(Object u : users)
			{
				String s = u.toString();
				System.out.println();
				//String name = u.getUserName();
			//	String password = u.getPassword();
				//User tmp =  new User(name,password);
				//newUsers.add(tmp);
			}
			//System.out.println();
			return newUsers;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}

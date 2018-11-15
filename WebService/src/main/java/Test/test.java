package Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.Swap.WebService.Model.User;

public class test {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("swap");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		User user = new User(12333,"333","333");
		
		entityManager.persist(user);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();

	}

}

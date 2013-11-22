package dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Person;

public enum PersonDao {
	instance;
	private static EntityManagerFactory emf;

	
	PersonDao() {
		initEntityManagerFactory();
	}
	
	
	public static void initEntityManagerFactory() {
		emf = Persistence.createEntityManagerFactory("introsde-jpa");
	}
	
	public EntityManager createEntityManager() {
		return emf.createEntityManager();
	}

	public void closeConnections(EntityManager em) {
		em.close();
	}

	public EntityTransaction getTransaction(EntityManager em) {
		return em.getTransaction();
	}
	
	
	public static Person getPersonById(Long personId) {
		EntityManager em = PersonDao.instance.createEntityManager();
		Person p = em.find(Person.class, personId);
		PersonDao.instance.closeConnections(em);
		return p;
	}
	
	public static List<Person> getAll() {
		EntityManager em = PersonDao.instance.createEntityManager();
	    List<Person> list = em.createNamedQuery("Person.findAll", Person.class).getResultList();
	    PersonDao.instance.closeConnections(em);
	    return list;
	}
	
	// add other database methods

}
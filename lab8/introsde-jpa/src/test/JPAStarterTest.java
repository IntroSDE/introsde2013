package test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.LifeStatus;
import model.MeasureDefinition;
import model.Person;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.PersonDao;

public class JPAStarterTest {

	@Test
	public void readPerson() {
		List<Person> list = em.createNamedQuery("Person.findAll", Person.class)
				.getResultList();
		assertEquals("Table has one entity", 1, list.size());
		assertEquals("Table has correct name", "Chuck", list.get(0).getName());
	}

	@Test
	public void addPerson() {
		// Arrange
		Person at = new Person();
		at.setName("Pinco");
		// Act
		tx.begin();
		em.persist(at);
		tx.commit();
		// Assert
		assertNotNull("Id should not be null", at.getIdPerson());
		List<Person> list = em.createNamedQuery("Person.findAll", Person.class)
				.getResultList();
		assertEquals("Table has two entities", 2, list.size());
		assertEquals("Table has correct name", "Pinco", list.get(1).getName());

		// Person p = em.find(Person.class, 2);
		Person p = list.get(1);

		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();

		list = em.createNamedQuery("Person.findAll", Person.class)
				.getResultList();

		assertEquals("Table has two entities", 1, list.size());
		assertEquals("Table has correct name", "Chuck", list.get(0).getName());

	}

	@Test
	public void addPersonWithDao() {

		// Arrange
		Person p = new Person();
		p.setName("Pinco");
		p.setLastname("Pallino");
		Calendar c = Calendar.getInstance();
		c.set(1984, 6, 21);
		p.setBirthdate(c.getTime());
		// Act
		Person.savePerson(p);
		// Assert
		assertNotNull("Id should not be null", p.getIdPerson());

		List<Person> list = Person.getAll();
		assertEquals("Table has two entities", 2, list.size());
		assertEquals("Table has correct name", "Pinco", list.get(1).getName());

		Person created = list.get(1);
		Person.removePerson(created);
		list = Person.getAll();

		assertEquals("Table has two entities", 1, list.size());
		assertEquals("Table has correct name", "Chuck", list.get(0).getName());
	}

	@Test
	public void addPersonWithLifeStatusDao() {

		// Arrange
		Person p = new Person();
		p.setName("Pinco");
		p.setLastname("Pallino");
		Calendar c = Calendar.getInstance();
		c.set(1984, 6, 21);
		p.setBirthdate(c.getTime());
		// Act
		p = Person.savePerson(p);
		// Assert
		assertNotNull("Id should not be null", p.getIdPerson());

		List<Person> list = Person.getAll();
		assertEquals("Table has two entities", 2, list.size());
		assertEquals("Table has correct name", "Pinco", list.get(1).getName());

		Person created = p;
		Person.removePerson(created);
		list = Person.getAll();
		
		List<LifeStatus> mList = LifeStatus.getAll();

		assertEquals("Only one person in DB", 1, list.size());
		assertEquals("Only one LifeStatus in DB", 1, mList.size());
		assertEquals("Only Person has correct name", "Chuck", list.get(0).getName());
		
		// setting weight for an existing person with existing measures
		Person chuck = Person.getPersonById(new Long(1));
		
		assertEquals("Chuck norris is here", "Chuck", chuck.getName());
		
		MeasureDefinition md = MeasureDefinition
				.getMeasureDefinitionById(new Long(1));
		LifeStatus l = new LifeStatus();
		l.setMeasureDefinition(md);
		l.setValue("85");
		chuck.getLifeStatus().add(l);
		chuck = Person.updatePerson(chuck);

		assertEquals("Person should have now two measures", 2, chuck.getLifeStatus().size());

		l=chuck.getLifeStatus().get(1);
		
		assertNotNull("LifeStatus measure was created", l.getIdMeasure());

		chuck.getLifeStatus().remove(1);
		Person.updatePerson(chuck);
		
		assertEquals("Person should have now just one measure", 1, chuck.getLifeStatus().size());
	}

	@BeforeClass
	public static void beforeClass() {
		emf = Persistence.createEntityManagerFactory("introsde-jpa");
		em = emf.createEntityManager();
	}

	@AfterClass
	public static void afterClass() {
		em.close();
		emf.close();
	}

	@Before
	public void before() {
		tx = em.getTransaction();
	}

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private EntityTransaction tx;
}

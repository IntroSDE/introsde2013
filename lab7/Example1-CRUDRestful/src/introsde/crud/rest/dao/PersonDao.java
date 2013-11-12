package introsde.crud.rest.dao;

import introsde.crud.rest.model.HealthProfile;
import introsde.crud.rest.model.Person;

import java.util.HashMap;
import java.util.Map;

public enum PersonDao {
	instance;

	private Map<String, Person> contentProvider = new HashMap<String, Person>();

	private PersonDao() {

		Person pallino = new Person();
		Person pallo = new Person("Pinco","Pallo");
		HealthProfile hp = new HealthProfile(68.0,1.72);
		Person john = new Person("John","Doe",hp);

		pallino.setId("1");
		pallo.setId("2");
		john.setId("3");
		
		contentProvider.put("1", pallino);
		contentProvider.put("2", pallo);
		contentProvider.put("3", john);

	}

	public Map<String, Person> getModel() {
		return contentProvider;
	}
}
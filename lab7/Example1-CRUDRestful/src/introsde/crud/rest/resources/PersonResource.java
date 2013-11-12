package introsde.crud.rest.resources;

import introsde.crud.rest.dao.PersonDao;
import introsde.crud.rest.model.Person;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

public class PersonResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	String id;

	public PersonResource(UriInfo uriInfo, Request request,String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
	}

	// Application integration
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Person getPerson() {
		Person person = PersonDao.instance.getModel().get(id);
		if (person == null)
			throw new RuntimeException("Get: Person with " + id + " not found");
		return person;
	}

	// for the browser
	@GET
	@Produces(MediaType.TEXT_XML)
	public Person getPersonHTML() {
		Person person = PersonDao.instance.getModel().get(id);
		if (person == null)
			throw new RuntimeException("Get: Person with " + id + " not found");
		return person;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putPerson(JAXBElement<Person> person) {
		Person c = person.getValue();
		return putAndGetResponse(c);
	}

	@DELETE
	public void deletePerson() {
		Person c = PersonDao.instance.getModel().remove(id);
		if (c == null)
			throw new RuntimeException("Delete: Person with " + id
					+ " not found");
	}

	private Response putAndGetResponse(Person person) {
		Response res;
		if (PersonDao.instance.getModel().containsKey(person.getId())) {
			res = Response.noContent().build();
		} else {
			res = Response.created(uriInfo.getAbsolutePath()).build();
		}
		PersonDao.instance.getModel().put(person.getId(), person);
		return res;
	}
}
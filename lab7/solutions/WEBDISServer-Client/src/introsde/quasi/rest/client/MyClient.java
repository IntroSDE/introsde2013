package introsde.quasi.rest.client;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class MyClient {
	WebResource service;
	
	public MyClient() {
		ClientConfig config = new DefaultClientConfig();
	    Client client = Client.create(config);
	    this.service = client.resource(getBaseURI());
	}
	
	public String addPerson(String personId, String fullname) {
		return this.service.path("SET").path(personId).path(fullname).get(String.class);
	}
	
	public String getPerson(String personId) {
		return (this.service.path("GET").path(personId).get(String.class));
	}
	
	public String addInfos(String fullname, double weight, double height) {
		String weightString = Double.toString(weight);
		String heightString = Double.toString(height);
		weightString.replace("/", "%2f");
		weightString.replace(".", "%2e");
		heightString.replace("/", "%2f");
		heightString.replace(".", "%2e");
		return this.service.path("HMSET").path(fullname).path("weight").path(weightString).path("height").path(heightString).get(String.class);
	}
	
	public String getInfos(String fullname) {
		return this.service.path("HMGET").path(fullname).path("weight").path("height").get(String.class);
	}

	public static void main(String[] args) { 
		MyClient test = new MyClient();
		System.out.println(test.addPerson("666", "El diablo"));
		System.out.println(test.getPerson("666"));
		System.out.println(test.addInfos("El diablo", 666, 666.666));
		System.out.println(test.getInfos("El diablo"));
	}
	
	private static URI getBaseURI() {
	    return UriBuilder.fromUri("http://test.lifeparticipation.org/webdis/").build();
	}

}

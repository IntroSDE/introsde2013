package client;
 
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import ws.People;
//import client.ws.People;
 
public class PeopleClient{
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:6902/ws/people?wsdl");
        //1st argument service URI, refer to wsdl document above
		//2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://ws/", "PeopleService");
        Service service = Service.create(url, qname);
        
        People people = service.getPort(People.class);
        System.out.println(people.readPerson(1).getName());
    }
}
package service.health;

import java.util.HashMap;
import java.util.Map;

import service.health.pojos.HealthProfile;
import service.health.pojos.Person;


public class HealthProfileReader {

	
	private static Map<String,Person> database = new HashMap<String,Person>();
	
	// we initialize the database in a static initialization block
	// static members of a class belong to the class instead of a specific instance.
	// this means that there is only one instance of the static field shared by all the 
	// instances of the class, even if you create a million instances of the class or 
	// you don't create any. It will be shared by all instances.
	// a static block is only executed once, the first time the class is instantiated
	static
    {
    	Person pallino = new Person();
		Person pallo = new Person("Pinco","Pallo");
		HealthProfile hp = new HealthProfile(68.0,1.72);
		Person john = new Person("John","Doe",hp);
		
		database.put(pallino.getFirstname()+" "+pallino.getLastname(), pallino);
		database.put(pallo.getFirstname()+" "+pallo.getLastname(), pallo);
		database.put(john.getFirstname()+" "+john.getLastname(), john);
    }


	/**
	 * The health profile reader gets information returns the health profile
	 * of a person
	 * 
	 * @param firstname the person's firstname
	 * @param firstname the person's lastname
	 */
	public HealthProfile getHealthProfile(String firstname, String lastname) {
		Person p= database.get(firstname+" "+lastname);
		if (p!=null) { 
			return p.gethProfile();
		} else {
			return null;
		}	
	}

	public String getParameterValue(String firstname, String lastname, String parameter) {
		Person p= database.get(firstname+" "+lastname);
		
		if (p!=null) {
	    	HealthProfile hp = p.gethProfile();
    		String measureValue = "";
   			if (parameter.equals("weight")) {
			   measureValue = hp.getWeight()+"";
		    } else if (parameter.equals("height")) {
	  		    measureValue = hp.getHeight()+"";
  		    } else if (parameter.equals("bmi")) {
  		        measureValue = hp.getBMI()+"";
  		    }
  		    return measureValue;    
	    } else {
	    	return "Something bad happened";
	    }  
	}

	public String setParameterValue(String firstname, String lastname, String parameter, double value) {
		Person p= database.get(firstname+" "+lastname);
		
		if (p!=null) {
	    	HealthProfile hp = p.gethProfile();

	    	if (parameter.equals("weight")) {
			   hp.setWeight(value);
		    } else if (parameter.equals("height")) {
	  		    hp.setHeight(value);
  		    } else if (parameter.equals("bmi")) {
  		        return "BMI cannot be updated";
  		    }
  		    return "Parameter "+parameter+" is now "+value;
	    } else {
	    	return "Something bad happened";
	    }  
	}
}

package dozerproject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.*;
import java.io.FileOutputStream;
import java.io.IOException;

import dozerproject.entity.PersonDB;
import dozerproject.transfer.PersonUI;
import org.dozer.DozerBeanMapper;

public class DozerMapper {
    
    public static void main (String argus[]){        
        DozerMapper mapper = new DozerMapper();
        PersonDB pdb = new PersonDB();
        pdb.setFirstName("Cristhian");
        pdb.setLastName("Parra");
        pdb.setAddress("Povo Trento");
        pdb.setDbID("1234");
        mapper.mapPerson(pdb);
    }

    public void mapPerson(PersonDB sourceObject) {
        List myMappingFiles = new ArrayList();
        myMappingFiles.add("File:./dozerMappings.xml");
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.setMappingFiles(myMappingFiles);
        System.out.println( mapper.getMappingFiles().toString());
        PersonUI destObject = (PersonUI) mapper.map(sourceObject, PersonUI.class);
        String xmlDocument = "person.xml";
        marshalPersonUIXML(new File(xmlDocument),destObject);
    }

    public void marshalPersonUIXML(File xmlDocument, PersonUI personUI) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PersonUI.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty("jaxb.formatted.output", new Boolean(true));
            marshaller.marshal(personUI, new FileOutputStream(xmlDocument));
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (PropertyException e) {
            System.out.println(e.toString());
        } catch (JAXBException e) {
            System.out.println(e.toString());
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soaa.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.soaa.entities.Student;
import org.soaa.entities.StudentList;

/**
 *
 * @author Muhammad Imran
 */
public class JavaMarshaller {

    public void doMarshalling(StudentList students)
    {
        try {
            JAXBContext context = JAXBContext.newInstance(StudentList.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(students, new FileOutputStream(new File("f://person.xml")));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(JavaMarshaller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(JavaMarshaller.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

}

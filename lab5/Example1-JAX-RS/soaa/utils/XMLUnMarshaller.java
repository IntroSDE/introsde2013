/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soaa.utils;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.soaa.entities.Student;
import org.soaa.entities.StudentList;

/**
 *
 * @author Muhammad Imran
 */
public class XMLUnMarshaller {

    public StudentList doUnMarshalling()
    {
        StudentList students=null;
        try {
            JAXBContext context = JAXBContext.newInstance(new Class[]{org.soaa.entities.StudentList.class});
            Unmarshaller unmarshaller = context.createUnmarshaller();
            students =  (StudentList)unmarshaller.unmarshal(new File("f://person.xml"));
        } catch (JAXBException ex) {
            Logger.getLogger(XMLUnMarshaller.class.getName()).log(Level.SEVERE, null, ex);
        }

        return students;
    }

}

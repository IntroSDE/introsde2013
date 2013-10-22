/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soaa.entities;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Muhammad Imran
 */
//@XmlType
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlRootElement(name ="Students")
public class StudentList {

    @XmlElements({@XmlElement(name="Student",type=Student.class)})
    private ArrayList<Student> studentList;

    public StudentList() {
        studentList = new ArrayList<Student>();
    }

    /**
     * @return the studentList
     */
    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    /**
     * @param studentList the studentList to set
     */
    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }



}

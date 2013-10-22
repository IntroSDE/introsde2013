/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soaa.entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Muhammad Imran
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlRootElement
public class Student extends Person{


    @XmlElement
    private int registrationNo;
    @XmlElement
    private String course;
    @XmlElement
    private int marks;

    public Student() {
    }

    public Student(int regno,String course, int marks,Person person) {
        super(person.getName(),person.getAge(), person.getAddress());
        this.registrationNo=regno;
        this.course = course;
        this.marks = marks;
    }

    /**
     * @return the course
     */
  
    public String getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * @return the marks
     */
 
    public int getMarks() {
        return marks;
    }

    /**
     * @param marks the marks to set
     */
    public void setMarks(int marks) {
        this.marks = marks;
    }

    /**
     * @return the registrationNo
     */
    public int getRegistrationNo() {
        return registrationNo;
    }

    /**
     * @param registrationNo the registrationNo to set
     */
    public void setRegistrationNo(int registrationNo) {
        this.registrationNo = registrationNo;
    }

 //system.out.println(matjos2003@gmail.com)

}

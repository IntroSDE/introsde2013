/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.soaa.services;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.soaa.entities.Student;
import org.soaa.entities.StudentList;
import org.soaa.utils.JavaMarshaller;
import org.soaa.utils.XMLUnMarshaller;

/**
 * REST Web Service
 *
 * @author Muhammad Imran
 */
@Path("/")
public class StudentResource {

    @Context
    private UriInfo context;

    /** Creates a new instance of StudentResource */
    public StudentResource() {
    }

    /**
     * Retrieves representation of an instance of org.soaa.services.StudentResource
     * @return an instance of java.lang.String
     */
    @Path("/student")
    @GET
    @Produces("application/xml")
    public Response getStudent() {

        XMLUnMarshaller unmarshaller = new XMLUnMarshaller();
        StudentList students = unmarshaller.doUnMarshalling();
        return Response.ok(students).build();

    }

    @Path("/student/{name}")
    @GET
    @Produces("application/xml")
    public Response getStudentByName(@PathParam("name") String name) {

        Student st = new Student();
        XMLUnMarshaller unmarshaller = new XMLUnMarshaller();
        StudentList students = unmarshaller.doUnMarshalling();
        for (Student student : students.getStudentList()) {
            System.out.println(student.getName());
            if (student.getName().equals(name)) {
                st = student;
                break;
            }
        }
        return Response.ok(st).build();

    }

    @Path("/student")
    @POST
    @Produces("text/plain")
    @Consumes(MediaType.APPLICATION_XML)
    public String newStudent(StudentList students) {
        XMLUnMarshaller unmarshaller = new XMLUnMarshaller();
        StudentList oldstudents = unmarshaller.doUnMarshalling();

        ArrayList<Student> list = oldstudents.getStudentList();
        for (Student student : students.getStudentList()) {
            list.add(student);
        }


        oldstudents.setStudentList(list);
        JavaMarshaller marshaller = new JavaMarshaller();
        marshaller.doMarshalling(oldstudents);

        return "student created";

    }

    @PUT
    @Path("/student")
    @Consumes("application/xml")
    public void updateStudent(StudentList newstudents) {
        XMLUnMarshaller unmarshaller = new XMLUnMarshaller();
        StudentList oldstudents = unmarshaller.doUnMarshalling();
        ArrayList<Student> studentList = oldstudents.getStudentList();
        for (Student newstudent : newstudents.getStudentList())
        {
        for (Student oldstudent : studentList) {
            if (oldstudent.getRegistrationNo()==newstudent.getRegistrationNo()) {
                studentList.remove(oldstudent);
                studentList.add(newstudent);
                break;
            }
        }
        }
        oldstudents.setStudentList(studentList);
        JavaMarshaller marshaller = new JavaMarshaller();
        marshaller.doMarshalling(oldstudents);
        
    }

    @DELETE
    @Path("/student/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteStudent(@PathParam("id") int id)
    {
        XMLUnMarshaller unmarshallar =new XMLUnMarshaller();
        StudentList students= unmarshallar.doUnMarshalling();
        ArrayList<Student> list = students.getStudentList();
        for (Student student: list)
        {
            if (student.getRegistrationNo() == id)
            {
                list.remove(student);
                break;
            }
        }
        students.setStudentList(list);
        JavaMarshaller marshaller = new JavaMarshaller();
        marshaller.doMarshalling(students);

        return "Deleted Successfully";
    }

    /**
     * PUT method for updating or creating an instance of StudentResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
}

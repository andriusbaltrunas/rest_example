package rest;

import rest.service.StudentsService;
import rest.utils.DbUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andriusbaltrunas on 5/23/2018.
 */
@Path("/myRest")
public class MyFirstRest {

    //localhost:8080/rest/myRest
    @GET
    public String sayHi(){
        return "Labukas";
    }
    //localhost:8080/rest/myRest/baubukas
    @GET
    @Path("/{name}")
    public String sayHi(@PathParam("name") String name){
        return "Labukas " + name;
    }

    @POST
    @Path("/{name}")
    public String sayHiPost(@PathParam("name") String name){
        return "Labas "+ name;
    }

    @POST
    @Path("/{id}/{surname}")
    public String printData(@PathParam("id") int id, @PathParam("surname") String surname){
        return surname + " " + id;
    }

    @POST
    @Path("/saveAndGet")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student saveAndGet(Student student){
        student.setName(student.getName() + "_test");
        student.setSurname(student.getSurname() + "_test");

        return student;
    }

    @GET
    @Path("/students")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudents(){
        StudentsService studentsService = new StudentsService();
        List<Student> students = studentsService.getStudents();
       /* students.add(new Student(12, "Andrius", "Baltrunas", "+3703324324", "andrius@kcs.com"));
        students.add(new Student(1, "JOnas", "Bla", "+4390583490", "jonas@kcs.com"));
        students.add(new Student(2, "Kazys", "Blob", "+4432356236236", "kazys@kcs.com"));*/
        return students;
    }

    @GET
    @Path("/{id}/student")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent(@PathParam("id") int id){
        StudentsService studentsService = new StudentsService();
        Student st = studentsService.getStudent(id);
        return st;
    }

    @GET
    @Path("/connect")
    public boolean isConnected(){
        DbUtils db = new DbUtils();
        Connection connection = db.createConnection();
        boolean isConnect = false;
        if(connection != null){
            isConnect = true;
        }
        return isConnect;
    }
}

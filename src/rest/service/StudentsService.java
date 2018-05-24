package rest.service;

import rest.Student;
import rest.utils.DbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andriusbaltrunas on 5/24/2018.
 */
public class StudentsService {

    private Connection connection;

    public StudentsService() {
        DbUtils db = new DbUtils();
        connection = db.createConnection();
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
                while (resultSet.next()) {
                    students.add(createStudent(resultSet));
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return students;
    }


    public void insertStudent(Student student) {
        //TODO INSERT STUDENT
    }

    public Student getStudent(int id) {
        Student student = new Student();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM students WHERE id=" + id);
                resultSet.next();
                student = createStudent(resultSet);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return student;
    }

    private Student createStudent(ResultSet resultSet) throws SQLException {
        Student st = new Student(resultSet.getInt("id"), resultSet.getString("name"),
                resultSet.getString("surname"), resultSet.getString("phone"), resultSet.getString("email"));
        return st;
    }

}

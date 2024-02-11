package courses;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBconnection;

public class Courses {
    public int course_id;
    public String course_name;

    // model for course
    public Courses(int course_id, String course_name) {
        this.course_id = course_id;
        this.course_name = course_name;
    }

    private Connection connect;
    DBconnection db = new DBconnection();

    // default constructor
    public Courses() {

        try {
            connect = db.load();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Courses> getCourse() {
        String select = "SELECT * FROM courses";
        ArrayList<Courses> course = new ArrayList<Courses>();
        try {
            PreparedStatement state = connect.prepareStatement(select);
            ResultSet set = state.executeQuery(select);
            while (set.next()) {
                course.add(new Courses(set.getInt("course_id"), set.getString("course_name")));
            }
            state.executeQuery();
            state.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return course;
    }
    public int getCourseId(String course_name) {
        String select = "SELECT course_id FROM courses WHERE course_name = ?";
        int course_id = 0;
        try {
            PreparedStatement state = connect.prepareStatement(select);
            state.setString(1, course_name);
            ResultSet set = state.executeQuery();
            while (set.next()) {
                course_id = set.getInt("course_id");
            }
            state.executeQuery();
            state.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return course_id;
    }
    
    public ArrayList<Courses> searchCourses(String searchText) {
        String select = "SELECT * FROM courses WHERE course_name LIKE ?";
        ArrayList<Courses> filteredCourses = new ArrayList<>();
        try {
            PreparedStatement state = connect.prepareStatement(select);
            state.setString(1, "%" + searchText + "%");
            ResultSet set = state.executeQuery();
            while (set.next()) {
                filteredCourses.add(new Courses(set.getInt("course_id"), set.getString("course_name")));
            }
            state.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return filteredCourses;
    }
}

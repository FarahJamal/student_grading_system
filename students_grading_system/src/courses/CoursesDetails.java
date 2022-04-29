package courses;

import connector.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CoursesDetails {
    public List<AddCourses> displayList() throws SQLException {
        DatabaseConnection dataBaseConnection=new DatabaseConnection();
         List<AddCourses> courses = new ArrayList<>();

        try {
            Connection conn = dataBaseConnection.dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM courses_db");
            System.out.println("All Courses: \ncourse name  course id  instructor");

            while (rs.next()) {
                System.out.printf("%s\t\t %s\t\t %s\t\t \n",
                        rs.getString("course_name"),
                        rs.getInt("course_id"),
                        rs.getString("instructor")
                );
                courses.add(new AddCourses(rs.getInt("course_id"),rs.getString("instructor"),rs.getString("course_name")));
            }
            System.out.println();
        }
        catch (Exception error){
          error.printStackTrace();
        }
        return courses;
    }

}

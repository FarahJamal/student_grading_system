package courses;

import connector.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegisterToNewCourseDAO {
    public void regToNewCourse(long roll, long course_id,String course_name)
    {
        DatabaseConnection dataBaseConnection=new DatabaseConnection();

        try
        {

            Connection connection = dataBaseConnection.dataSource.getConnection();
            Statement statement=connection.createStatement();
            ResultSet courseId=statement.executeQuery("SELECT * FROM courses_db WHERE course_id='"+course_id+ "' AND course_name='"+course_name+"'");
            if(courseId.next()) {
                String q = "insert into std_courses (student_roll,course_id,course_name) values ('" + roll + "'," + course_id + ",'" + course_name + "')";
                statement.executeUpdate(q);
                System.out.printf("you have been registered to the %s class ", course_name);
                connection.close();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
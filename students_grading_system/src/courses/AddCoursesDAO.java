package courses;

import connector.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddCoursesDAO {
    public void addNewCourseToDB(long course_id, String instructor , String  courseName, int numberOfStudents)
    {
        DatabaseConnection dataBaseConnection=new DatabaseConnection();

        try
        {

            Connection connection = dataBaseConnection.dataSource.getConnection();

            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from courses_db");
            boolean isUnique=true;
            while(resultSet.next())
            {
                String s1=course_id+" "+instructor+" "+courseName;
                String s2=resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3);
                if(s1.equalsIgnoreCase(s2))
                {
                    System.out.println("Credentials are not Unique");
                    isUnique=false;
                    break;
                }
            }
            if(isUnique)
            {
                statement.executeUpdate("insert into courses_db (course_id, instructor,course_name,number_of_std) values ('"+course_id+"','"+instructor+"','"+courseName+"','"+numberOfStudents+"')");
                System.out.println("course registered successfully!");
            }
            connection.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
package results;

import connector.DatabaseConnection;

import java.sql.Connection;
import java.sql.Statement;

public class UploadStudentMarksDAO {

    public void uploadStudentMarks(long roll, int marks, String subject)
{

    DatabaseConnection dataBaseConnection=new DatabaseConnection();

        try
    {

        Connection connection = dataBaseConnection.dataSource.getConnection();

         Statement smt=connection.createStatement();

                String q="UPDATE students_marks SET mark='"+marks+"' WHERE student_roll='"+roll+"' AND course_name LIKE'"+subject+"'";
                smt.executeUpdate(q);

                connection.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
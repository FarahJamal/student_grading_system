package generate_results;

import connector.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;

public class GenerateResultDAO {
    public List<GenerateResults> getAllData(Long roll)
    {
        DatabaseConnection dataBaseConnection=new DatabaseConnection();
List<GenerateResults> results=new ArrayList<>();
        try
        {

            Connection connection = dataBaseConnection.dataSource.getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from students_marks where student_roll="+roll);
            System.out.println("Roll Number\t\t Name \tInstructor\tMark");
            while(resultSet.next())
            {
                System.out.println(resultSet.getString(1)+"\t\t"+resultSet.getString("course_name")+"\t"+resultSet.getString("instructor")+"\t\t"+resultSet.getInt("mark"));

                    results.add(new GenerateResults(resultSet.getLong(1),resultSet.getString("course_name"),resultSet.getString("instructor"),resultSet.getInt("mark")));


            }
            connection.close();
        }
        catch(Exception e)
        {
            System.out.println("Ehh Error :(");
        }
        return results;
    }

    public List<GenerateResults> getClassMarksDetails(String courseName, long rollNo)
    {
        String pronoun;
        DatabaseConnection dataBaseConnection=new DatabaseConnection();
List<GenerateResults>results=new ArrayList<>();
        List<Integer> marks=new ArrayList<>();
        try
        {

            Connection con = dataBaseConnection.dataSource.getConnection();

            Statement smt=con.createStatement();
            ResultSet rs;
            if(!courseName.equals("none")){
                rs=smt.executeQuery("select * from students_marks where course_name='"+courseName+"'");
                pronoun=courseName;

            }
            else{
                rs=smt.executeQuery("select * from students_marks where student_roll="+rollNo);
                pronoun="Your";

            }

            while(rs.next())
            {
                marks.add(rs.getInt("mark"));
            }
            OptionalDouble average = marks
                    .stream()
                    .mapToDouble(a -> a)
                    .average();
            System.out.printf("%s marks Average: %s \n",pronoun,average.getAsDouble());
            OptionalInt max = marks
                    .stream()
                    .mapToInt(a -> a)
                    .max();
            System.out.printf("%s marks max: %s \n",pronoun,max.getAsInt());
            OptionalInt min = marks
                    .stream()
                    .mapToInt(a -> a)
                    .min();
            System.out.printf("%s marks min: %s \n",pronoun,min.getAsInt());
            DoubleStream sortedNumbers = marks.stream()
                    .mapToDouble(v -> v)
                    .sorted();
            OptionalDouble median = (
                    marks.size() % 2 == 0 ?
                            sortedNumbers.skip((marks.size() / 2) - 1)
                                    .limit(2)
                                    .average() :
                            sortedNumbers.skip(marks.size() / 2)
                                    .findFirst()
            );
            System.out.printf("%s marks median: %s \n",pronoun,median.getAsDouble());

            GenerateResults generateResults=new GenerateResults(average.getAsDouble(),median.getAsDouble(),min.getAsInt(),max.getAsInt());
            results.add(generateResults);
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Ehh Error :(");
        }
        return results;
    }
}
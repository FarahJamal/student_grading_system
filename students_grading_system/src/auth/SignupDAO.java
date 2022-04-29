package auth;

import connector.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SignupDAO
{
    public void newUser(String role, String username, String email, String password)
    {
        DatabaseConnection dataBaseConnection=new DatabaseConnection();

        try
        {

            Connection connection = dataBaseConnection.dataSource.getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from user");
            boolean isUnique=true;
            while(resultSet.next())
            {
                String userValues=role+" "+username+" "+password+" "+email;
                String systemValues=resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4);
                if(userValues.equalsIgnoreCase(systemValues))
                {
                    System.out.println("Credentials are not Unique");
                    isUnique=false;
                    break;
                }
            }
            if(isUnique)
            {
                statement.executeUpdate("insert into user (user_role, username,password,email) values ('"+role+"','"+username+"','"+password+"','"+email+"')");
                System.out.println("You have been Successfully registered as user");
            }
            connection.close();
        }
        catch(Exception error)
        {
            System.out.println("An error occurred in our Database please try again later 🤔🤔");
            error.printStackTrace();
        }
    }
}
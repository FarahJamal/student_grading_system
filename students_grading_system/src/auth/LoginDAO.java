package auth;

import connector.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {
        public long userRoll;
        public String userRole;
        DatabaseConnection dataBaseConnection=new DatabaseConnection();

        public boolean userLogin(String role, String username, String password)
        {
            UserData userData=new UserData();
            try
            {

                Connection connection = dataBaseConnection.dataSource.getConnection();
                Statement statement=connection.createStatement();

                ResultSet resultSet=statement.executeQuery("SELECT * FROM user WHERE username='"+username+"' AND password='"+password+"'");
                while(resultSet.next())
                {

                    String s1,s2;
                    if(role==""){
                         s1=username+" "+password;
                         s2=resultSet.getString(2)+" "+resultSet.getString(3);
                    }
                    else{
                         s1=role+" "+username+" "+password;
                         s2=resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3);
                    }

                    if(s1.equalsIgnoreCase(s2))
                    {
                        System.out.println("Login Successful");
                        userData.setUserRoll(resultSet.getLong("roll_no"));
                        userRoll=userData.getUserRoll();
                        userData.setUserRole(resultSet.getString(1));
                        userRole=userData.getUserRole();
                        return true;
                    }
                }
                connection.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.out.println("Login Failed");
                return false;
            }
            return false;
        }
    }
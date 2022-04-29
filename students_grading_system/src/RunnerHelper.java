

import auth.LoginDAO;
import auth.SignupDAO;
import courses.AddCoursesDAO;
import courses.CoursesDetails;
import courses.RegisterToNewCourseDAO;
import generate_results.GenerateResultDAO;
import results.UploadStudentMarksDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class RunnerHelper {
    String userChoice;
    boolean jobDone=false;


    public void run() throws SQLException {
        Scanner input=new Scanner(System.in);
        while (!jobDone){
            System.out.println("Press (1) to Login, Press (2) to SignUp and Press (3) to exit");
            int choice=input.nextInt();
            if(choice==1)
            {
                System.out.print("Enter (1) if you are Admin, (2) for Teacher and (3) for Student: ");
                userChoice=input.nextLine();
                String role=input.nextLine();
                System.out.print("Enter Your Username: ");
                String username=input.nextLine();
                System.out.print("Enter Your Password: ");
                String password=input.nextLine();
                LoginDAO login=new LoginDAO();
                boolean hasLoggedIn=login.userLogin(role,username,password);

                while(hasLoggedIn)
                {
                    if(role.equalsIgnoreCase("1"))
                    {
                        System.out.println("Press (1) to add New Student, (2) to Generate Result  (3) to Add new course and (4) to LogOut");
                        choice=input.nextInt();
                        if(choice==1)
                        {
                            userChoice=input.nextLine();
                            System.out.print("Enter the Name: ");
                            String name=input.nextLine();
                            System.out.print("Enter the Email: ");
                            String email=input.nextLine();
                            System.out.print("Enter the Password");
                            String stdPassword=input.next();
                            userChoice=input.nextLine();
                            System.out.print("Enter the Student's Contact Number: ");
                            SignupDAO signup=new SignupDAO();
                            signup.newUser("3",name,email,stdPassword);
                        }
                        else if(choice==2)
                        {
                            System.out.print("Enter the Roll Number: ");
                            long rollno=input.nextLong();
                            GenerateResultDAO results=new GenerateResultDAO();
                            results.getAllData(rollno);
                            System.out.print("Enter course Name you want to get details, none to get user details ");
                            String courseName="";
                            courseName=input.next();
                            results.getClassMarksDetails(courseName,rollno);
                        }
                        else if(choice==3){
                            CoursesDetails courses=new CoursesDetails();

                            courses.displayList();
                            System.out.print("Enter the course id: ");
                            long course_id=input.nextLong();
                            System.out.print("Enter the course name : ");
                            String courseName=input.next();
                            System.out.print("Enter the instructor name: ");
                            String instructorName=input.next();
                            System.out.print("Enter the number of default students: ");
                            int numberOfStudents=input.nextInt();
                            AddCoursesDAO addNewCourse=new AddCoursesDAO();
                            addNewCourse.addNewCourseToDB(course_id,instructorName,courseName,numberOfStudents);
                        }
                        else if(choice==4)
                        {
                            hasLoggedIn=false;
                            break;
                        }
                    }
                    else if(role.equalsIgnoreCase("2"))
                    {
                        System.out.println("Enter (1) to enter marks and (2) to exit");
                        choice=input.nextInt();
                        if(choice==1)
                        {
                            System.out.print("Enter the Roll Number: ");
                            long roll=input.nextLong();
                            System.out.print("Enter the Marks: ");
                            int marks=input.nextInt();
                            System.out.print("Enter the Subject Name: ");
                            String subject=input.next();
                            UploadStudentMarksDAO uploadStudentMarks=new UploadStudentMarksDAO();
                            uploadStudentMarks.uploadStudentMarks(roll,marks,subject);
                        }
                        else
                        {
                            hasLoggedIn=false;
                            break;
                        }
                    }
                    else if(role.equalsIgnoreCase("3"))
                    {
                        System.out.println("Enter (1) to Generate Result, (2) to register to new course and (3) to exit");
                        choice=input.nextInt();
                        if(choice==1)
                        {
                            long rollno=login.userRoll;
                            GenerateResultDAO results=new GenerateResultDAO();

                            results.getAllData(rollno);
                            System.out.print("Enter course Name you want to get details, none to get user details ");

                            String courseName="";
                            courseName=input.next();
                            results.getClassMarksDetails(courseName,rollno);
                        }
                        else if(choice==2){
                            CoursesDetails courses=new CoursesDetails();

                            courses.displayList();

                            RegisterToNewCourseDAO registerNewCourse=new RegisterToNewCourseDAO();
                            System.out.println("Enter the course id :");
                            Long courseId=input.nextLong();
                            System.out.println("Enter the course name :");
                            String courseName= input.next();
                            registerNewCourse.regToNewCourse(login.userRoll,courseId,courseName);
                        }
                        else
                        {
                            hasLoggedIn=false;
                            break;
                        }
                    }
                }
            }
            else if(choice==2)
            {
                System.out.print("Enter (1) if you are Admin, (2) for Teacher and (3) for Student: ");
                userChoice=input.nextLine();
                String role=input.nextLine();
                System.out.print("Enter Your Username: ");
                String username=input.nextLine();
                System.out.print("Enter Your Email: ");
                String email=input.nextLine();
                System.out.print("Enter Your Password: ");
                String password=input.nextLine();

                SignupDAO signup=new SignupDAO();
                signup.newUser(role,username,email,password);
            }
            else if(choice==3)
            {
                break;
            }
        }
    }

}

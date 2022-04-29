package servlet.courses;

import auth.LoginDAO;
import auth.UserData;
import courses.AddCourses;
import courses.AddCoursesDAO;
import courses.CoursesDetails;
import courses.RegisterToNewCourseDAO;
import generate_results.GenerateResultDAO;
import generate_results.GenerateResults;
import servlet.login.LoginService;
import servlet.login.LoginServlet;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CourseServices  {

    public List<AddCourses> retrieveCourses() throws SQLException {
        CoursesDetails coursesDetails=new CoursesDetails();
        return coursesDetails.displayList();

    }


    public List<GenerateResults> retrieveMyCourses() throws SQLException {
        GenerateResultDAO results=new GenerateResultDAO();
        Context context = Context.getCurrentInstance();
        HttpSession session = context.getSession();
        long roll= (long) session.getAttribute("sharedRoll");
        return results.getAllData(roll);

    }


    public List<GenerateResults> getMarks(String courseName) throws SQLException {
        GenerateResultDAO results=new GenerateResultDAO();
        Context context = Context.getCurrentInstance();
        HttpSession session = context.getSession();
        long roll= (long) session.getAttribute("sharedRoll");

        return results.getClassMarksDetails(courseName,roll);

    }


    public void addCourse(long course_id, String instructor , String courseName, int numberOfStd) {
        AddCoursesDAO addCourses=new AddCoursesDAO();
        addCourses.addNewCourseToDB(course_id,instructor,courseName,numberOfStd);
    }

    public  void regToNewCourse(long roll, long course_id,String course_name){
        RegisterToNewCourseDAO registerToNewCourse=new RegisterToNewCourseDAO();
        registerToNewCourse.regToNewCourse(roll,course_id,course_name);
    }
//    public void deleteCourse(Todo todo) {
//        todos.remove(todo);
//    }
}

package servlet.courses;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(urlPatterns = "/add-course")
public class RegisterToNewCourse extends HttpServlet {

    private CourseServices courseServices = new CourseServices();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/my-courses.jsp").forward(
                request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        long roll = Long.parseLong(request.getParameter("roll").toString());
        long course_id = Long.parseLong(request.getParameter("course_id"));
        String courseName=request.getParameter("course_name");
       courseServices.regToNewCourse(roll,course_id,courseName);
        response.sendRedirect("/my-courses");
    }
}
package servlet.courses;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public @WebServlet(urlPatterns = "/my-courses")
class MyCoursesList extends HttpServlet {
    CourseServices courseServices=new CourseServices();
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        try(Context context=Context.create(request,response) ) {

            request.setAttribute("myCourses", courseServices.retrieveMyCourses());
            request.setAttribute("courses", courseServices.retrieveCourses());
            String courseName=request.getParameter("select");
            System.out.println(courseName);
            request.setAttribute("marks",courseServices.getMarks(courseName));
            request.getSession().getAttribute("sharedRoll");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/views/my-courses.jsp").forward(
                request, response);
    }

}

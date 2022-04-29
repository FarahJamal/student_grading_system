package servlet.courses;

import servlet.signup.AddUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/new-course")

public class AddNewCourseServlet extends HttpServlet {

    private CourseServices addCourse = new CourseServices();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/new-course.jsp").forward(
                request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        long courseId=Long.parseLong(request.getParameter("courseId"));
        String courseName=request.getParameter("courseName");
        String instructor=request.getParameter("instructor");
        int numberOfStd=Integer.parseInt(request.getParameter("numberOfStd"));
        addCourse.addCourse(courseId,instructor,courseName,numberOfStd);
        response.sendRedirect("/admin-dashboard");
    }
}

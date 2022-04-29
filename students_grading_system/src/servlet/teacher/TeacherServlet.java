package servlet.teacher;

import servlet.courses.Context;
import servlet.courses.CourseServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/new-mark")

public class TeacherServlet extends HttpServlet {

    private final TeacherService addMark = new TeacherService();
CourseServices courseServices=new CourseServices();
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        try(Context context=Context.create(request,response) ) {

            request.setAttribute("courses", courseServices.retrieveCourses());
            String courseName=request.getParameter("select");
            System.out.println(courseName);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/views/add-marks.jsp").forward(
                request, response);
    }




    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException {
        long roll=Long.parseLong(request.getParameter("roll"));
        String courseName=request.getParameter("courseName");
        int mark=Integer.parseInt(request.getParameter("mark"));


        try(Context context=Context.create(request,response)) {
            addMark.addMark(roll,mark,courseName);
            response.sendRedirect("/new-mark");


        } catch (SQLException e) {
            request.getRequestDispatcher("/WEB-INF/views/add-marks.jsp").forward(
                    request, response);
            e.printStackTrace();
        }

    }
}

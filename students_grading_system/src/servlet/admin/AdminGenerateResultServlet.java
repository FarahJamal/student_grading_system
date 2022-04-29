package servlet.admin;

import servlet.courses.Context;
import servlet.courses.CourseServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

 @WebServlet(urlPatterns = "/results")
public class AdminGenerateResultServlet  extends HttpServlet {
    AdminDashboardService adminDashboardService=new AdminDashboardService();
     CourseServices courseServices=new CourseServices();

     protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        try(Context context=Context.create(request,response) ) {
            request.setAttribute("courses", courseServices.retrieveCourses());
            String courseName="none";

            if(request.getParameter("select")!=null)
             courseName=request.getParameter("select");


            long rollNumber=0;

if(request.getParameter("roll")!=null && request.getParameter("roll")!="")
        rollNumber = Long.parseLong(request.getParameter("roll"));

    request.setAttribute("marks", adminDashboardService.getMarks(courseName, rollNumber));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/views/list-marks.jsp").forward(
                request, response);
    }

}

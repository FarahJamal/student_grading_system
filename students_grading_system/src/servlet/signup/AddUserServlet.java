package servlet.signup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/signup")
public class AddUserServlet extends HttpServlet {

    private AddUserService addUser = new AddUserService();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/add-user.jsp").forward(
                request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        String  role=request.getParameter("role");
        String username=request.getParameter("username");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        addUser.signUp(role,username,email,password);
        response.sendRedirect("/login");
    }
}
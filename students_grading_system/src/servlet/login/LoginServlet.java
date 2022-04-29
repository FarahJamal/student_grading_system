package servlet.login;


import auth.UserData;
import com.mysql.cj.log.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	private LoginService userValidationService = new LoginService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		UserData userData=new UserData();
		boolean isUserValid = userValidationService.isUserValid(name, password);
		userData.setUserRoll(userValidationService.login.userRoll);
		userData.setUserRole(userValidationService.login.userRole);
		request.setAttribute("sharedRoll", userData.getUserRoll()); // add to request
		request.getSession().setAttribute("sharedRoll", userData.getUserRoll()); // add to session
		this.getServletConfig().getServletContext().setAttribute("sharedRoll", userData.getUserRoll());

		request.setAttribute("sharedRole", userData.getUserRole()); // add to request
		request.getSession().setAttribute("sharedRole", userData.getUserRole()); // add to session
		this.getServletConfig().getServletContext().setAttribute("sharedRole", userData.getUserRole());

		if (isUserValid) {
			request.getSession().setAttribute("name", name);

			if(userData.getUserRole().equalsIgnoreCase("1")){
				response.sendRedirect("/admin-dashboard");

			}
			else if(userData.getUserRole().equalsIgnoreCase("2")){
response.sendRedirect("/new-mark");
			}
			else{
				response.sendRedirect("/courses");

			}

		} else {
			request.setAttribute("errorMessage", "Invalid Credentials!");
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(
					request, response);
		}
	}

}
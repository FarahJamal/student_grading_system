package servlet.login;

import auth.LoginDAO;

public class LoginService {
	LoginDAO login=new LoginDAO();

	public LoginDAO getLogin() {
		return login;
	}

	public boolean isUserValid(String user, String password) {

		return login.userLogin("",user,password);

	}

}

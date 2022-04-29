package servlet.signup;

import auth.Signup;
import auth.SignupDAO;
import courses.AddCoursesDAO;

public class AddUserService {

    public void signUp(String role, String username, String email, String password) {
        SignupDAO signup=new SignupDAO();
        signup.newUser(role,username,email,password);
    }

}

package auth;

public class UserData{
    long userRoll;
String userRole;

    public String getUserRole() {
        System.out.println("from user role ==> "+userRole);

        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public long getUserRoll() {

        System.out.println("from user rolls ==> "+userRoll);
        return userRoll;
    }

    public void setUserRoll(long userRoll) {
        this.userRoll = userRoll;
    }
}
package servlet.teacher;

import generate_results.GenerateResultDAO;
import generate_results.GenerateResults;
import results.UploadStudentMarks;
import results.UploadStudentMarksDAO;

import java.sql.SQLException;
import java.util.List;

public class TeacherService {

    public void addMark(long roll,int mark,String courseName) throws SQLException {
        UploadStudentMarksDAO addMark=new UploadStudentMarksDAO();
         addMark.uploadStudentMarks(roll,mark,courseName);
    }

}

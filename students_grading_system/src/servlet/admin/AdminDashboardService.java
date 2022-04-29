package servlet.admin;

import generate_results.GenerateResultDAO;
import generate_results.GenerateResults;

import java.sql.SQLException;
import java.util.List;

public class AdminDashboardService {

    public List<GenerateResults> getMarks(String courseName, long roll) throws SQLException {
        GenerateResultDAO results=new GenerateResultDAO();
        return results.getClassMarksDetails(courseName,roll);

    }

}

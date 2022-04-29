package com.example.std_mang_sys.data;

import com.example.std_mang_sys.model.Courses;
import com.example.std_mang_sys.model.Marks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Profile("database")
public class MarksDatabaseDAO implements MarksDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MarksDatabaseDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Marks> getAll() {
        final String sql = "SELECT * FROM students_marks";
        return jdbcTemplate.query(sql, new MarksMapper());

    }

    @Override
    public List<Marks> findById(long roll) {
        final String sql = "SELECT * FROM students_marks WHERE student_roll=?";
        System.out.println("roll "+roll);
        return jdbcTemplate.query(sql, new MarksDatabaseDAO.MarksMapper(), roll);
    }

    @Override
    public List<Marks> getMarksDetails(long roll) {
        final String sql = "SELECT * FROM students_marks WHERE student_roll=?";

        return jdbcTemplate.query(sql, new MarksDatabaseDAO.MarksMapper(), roll);
    }

    @Override
    public List<Marks> getMarkByCourse(String courseName) {
        final String sql = "SELECT * FROM students_marks WHERE course_name=?";

        return jdbcTemplate.query(sql, new MarksDatabaseDAO.MarksMapper(), courseName);    }


    private static final class MarksMapper implements RowMapper<Marks> {

        @Override
        public Marks mapRow(ResultSet rs, int index) throws SQLException {
            Marks td = new Marks();
            td.setCourseName(rs.getString("course_name"));
            td.setStudentRoll(rs.getLong("student_roll"));
            td.setInstructor(rs.getString("instructor"));
            td.setCourse_id(rs.getLong("course_id"));
            td.setMark(rs.getInt("mark"));
            return td;
        }
    }
}

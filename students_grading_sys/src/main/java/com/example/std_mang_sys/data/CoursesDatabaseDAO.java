package com.example.std_mang_sys.data;

import com.example.std_mang_sys.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Repository
@Profile("database")
public class CoursesDatabaseDAO implements CoursesDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CoursesDatabaseDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Courses add(Courses courses) {
        final String sql = "INSERT INTO courses_db(course_id, instructor,course_name,number_of_std) VALUES(?,?,?,?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);

            statement.setLong(1, courses.getCourse_id());
            statement.setString(2, courses.getInstructor());
            statement.setString(3,courses.getCourseName());
            statement.setInt(4,courses.getNumberOfStd());
            return statement;

        }, keyHolder);


        return courses;
    }

    @Override
    public List<Courses> getAll() {
        final String sql = "SELECT * FROM courses_db";
        return jdbcTemplate.query(sql, new CoursesMapper());
    }



    @Override
    public Courses findById(int id) {
        final String sql = "SELECT * FROM courses_db WHERE course_id = ?;";

        return jdbcTemplate.queryForObject(sql, new CoursesMapper(), id);
    }

    @Override
    public boolean update(Courses courses) {
        final String sql = "UPDATE courses_db SET "
                + "course_name = ?, "
                + "instructor = ?, "
                +"number_of_std = ?"
                + " WHERE course_id = ?;";

        System.out.println( "bla bla bla "+
                courses);

        return jdbcTemplate.update(sql,
                courses.getCourseName(),
                courses.getInstructor(),
                courses.getNumberOfStd(),
                courses.getCourse_id()
        ) > 0;    }

    @Override
    public boolean deleteById(int id) {
        final String sql = "DELETE FROM courses_db WHERE course_id = ?;";
        return jdbcTemplate.update(sql, id) > 0;
    }

    private static final class CoursesMapper implements RowMapper<Courses> {

        @Override
        public Courses mapRow(ResultSet rs, int index) throws SQLException {
            Courses td = new Courses();
            td.setNumberOfStd(rs.getInt("number_of_std"));
            td.setCourseName(rs.getString("course_name"));
            td.setInstructor(rs.getString("instructor"));
            td.setCourse_id(rs.getLong("course_id"));
            return td;
        }
    }
}

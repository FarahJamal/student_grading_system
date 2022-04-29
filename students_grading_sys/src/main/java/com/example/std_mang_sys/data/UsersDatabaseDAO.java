package com.example.std_mang_sys.data;

import com.example.std_mang_sys.model.Courses;
import com.example.std_mang_sys.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Repository
@Profile("database")
public class UsersDatabaseDAO implements UsersDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersDatabaseDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Users add(Users users) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        final String sql = "INSERT INTO user (user_role, username,password,email)  VALUES(?,?,?,?);";
        try {
            jdbcTemplate.update((Connection conn) -> {
                PreparedStatement statement = conn.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS);

                statement.setString(1, users.getRole());
                statement.setString(2, users.getUsername());
                statement.setString(3, users.getPassword());
                statement.setString(4, users.getEmail());

                return statement;

            }, keyHolder);
        } catch (Exception ex) {
            System.out.println("error " + ex.getMessage());

        }

        return users;
    }

    @Override
    public Users findByUsername(String username, String password) {
        final String sql = "SELECT * FROM user WHERE username='"+username+"' AND password='"+password+"'";
        return jdbcTemplate.queryForObject(sql, new UsersDatabaseDAO.UsersMapper(), username,password);
    }


    @Override
    public boolean update(Users users) {
        return false;
    }

    @Override
    public boolean deleteByRoll(long roll) {
        return false;
    }

    @Override
    public Users loginUser(Users users) {
        String sql = "SELECT * FROM user WHERE username=? AND password=?";

        try {
            System.out.println(
                    users.getUsername()
            );
            System.out.println(users.getPassword());
            return jdbcTemplate.queryForObject(sql, new UsersDatabaseDAO.UsersMapper(), users.getUsername(),users.getPassword());

        } catch (Exception e) {
            return null;
        }
    }


    private static final class UsersMapper implements RowMapper<Users> {

        @Override
        public Users mapRow(ResultSet rs, int index) throws SQLException {
            Users td = new Users();
            td.setUsername(rs.getString("username"));
            td.setEmail(rs.getString("email"));
            td.setRole(rs.getString("user_role"));
            td.setPassword(rs.getString("password"));
            return td;
        }
    }
}



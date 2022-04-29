package com.example.std_mang_sys.data;

import com.example.std_mang_sys.model.Users;

import java.util.List;

public interface UsersDAO {
    Users add(Users users);

    Users findByUsername(String username,String password);

    boolean update(Users users);

    boolean deleteByRoll(long roll);

    Users loginUser(Users users);
}


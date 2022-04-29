package com.example.std_mang_sys.data;

import com.example.std_mang_sys.model.Courses;

import java.util.List;

public interface CoursesDAO {

    Courses add(Courses courses);

    List<Courses> getAll();

    Courses findById(int id);

    boolean update(Courses courses);

    boolean deleteById(int id);
}

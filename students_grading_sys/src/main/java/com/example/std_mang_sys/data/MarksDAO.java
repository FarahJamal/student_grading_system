package com.example.std_mang_sys.data;

import com.example.std_mang_sys.model.Marks;

import java.util.List;

public interface MarksDAO {


    List<Marks> getAll();

    List<Marks> findById(long roll);

    List<Marks> getMarksDetails(long roll);

    List<Marks> getMarkByCourse(String courseName);


}

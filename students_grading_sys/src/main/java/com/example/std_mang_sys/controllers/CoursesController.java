package com.example.std_mang_sys.controllers;

import com.example.std_mang_sys.data.CoursesDAO;
import com.example.std_mang_sys.data.MarksDAO;
import com.example.std_mang_sys.model.Courses;
import com.example.std_mang_sys.model.Marks;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {
    private final CoursesDAO coursesDAO;
    private final MarksDAO marksDAO;

    public CoursesController(CoursesDAO coursesDAO, MarksDAO marksDAO) {
        this.coursesDAO = coursesDAO;
        this.marksDAO = marksDAO;
    }

    @GetMapping
    public List<Courses>all(){
return coursesDAO.getAll();
    }


    @GetMapping("/my-courses/{roll}")
    public List<Marks> myCourses(@PathVariable long roll){
        List<Marks> coursesData = marksDAO.findById(roll);
        return coursesData;
    }

    @GetMapping("/details/{roll}")
    public List<Object> myCoursesMarks(@PathVariable long roll)  {
        List<Marks> coursesData = marksDAO.getMarksDetails(roll);
        MarksDetails marksDetails=new MarksDetails();
        return marksDetails.getDetails(coursesData);
    }

    @GetMapping("/all-details/{courseName}")
    public List<Object> CourseMarks(@PathVariable String courseName) {
        List<Marks> coursesData = marksDAO.getMarkByCourse(courseName);
        System.out.println("frs "+coursesData);
        MarksDetails marksDetails=new MarksDetails();
        return marksDetails.getDetails(coursesData);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Courses create(@RequestBody Courses Courses) {
        return coursesDAO.add(Courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Courses> findById(@PathVariable int id) {
        Courses result = coursesDAO.findById(id);
        if (result == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody Courses courses) {

courses.setCourse_id(id);
        ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
        if (id != courses.getCourse_id()) {
            response = new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        } else if (coursesDAO.update(courses)) {
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if (coursesDAO.deleteById(id)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}

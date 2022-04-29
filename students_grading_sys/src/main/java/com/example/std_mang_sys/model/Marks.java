package com.example.std_mang_sys.model;

public class Marks {
    long studentRoll;
    long course_id;
    int mark;
    String courseName;
    String instructor;

    public long getStudentRoll() {
        return studentRoll;
    }

    public void setStudentRoll(long studentRoll) {
        this.studentRoll = studentRoll;
    }

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "{" +
                "studentRoll:" + studentRoll +
                ", course_id:" + course_id +
                ", mark:" + mark +
                ", courseName:" + courseName  +
                ", instructor:" + instructor +
                '}';
    }
}

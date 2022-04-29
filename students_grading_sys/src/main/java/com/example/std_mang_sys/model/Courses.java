package com.example.std_mang_sys.model;

public class Courses {
    int id;
    int numberOfStd;
    long course_id;
    String instructor;
    String courseName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfStd() {
        return numberOfStd;
    }

    public void setNumberOfStd(int numberOfStd) {
        this.numberOfStd = numberOfStd;
    }

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", numberOfStd=" + numberOfStd +
                ", course_id=" + course_id +
                ", instructor='" + instructor + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}

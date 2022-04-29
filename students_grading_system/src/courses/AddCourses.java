package courses;

public class AddCourses {
    int numberOfStudents;
    long course_id;
    String instructor ;
    String  courseName;

    public AddCourses(long course_id, String instructor, String courseName) {
        this.course_id = course_id;
        this.instructor = instructor;
        this.courseName = courseName;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
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
        return "{" +
                "numberOfStudents:" + numberOfStudents +
                ", course_id:" + course_id +
                ", instructor:" + instructor + '\'' +
                ", courseName:" + courseName + '\'' +
                '}';
    }
}
package results;

public class UploadStudentMarks {
    long roll;
    int mark;
    String courseName;

    public UploadStudentMarks(long roll, int mark, String courseName) {
        this.roll = roll;
        this.mark = mark;
        this.courseName = courseName;
    }

    public long getRoll() {
        return roll;
    }

    public void setRoll(long roll) {
        this.roll = roll;
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

    @Override
    public String toString() {
        return "{" +
                "roll:" + roll +
                ", mark:" + mark +
                ", courseName:" + courseName  +
                '}';
    }
}

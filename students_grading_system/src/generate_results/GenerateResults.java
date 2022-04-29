package generate_results;

public class GenerateResults {
    long rollNumber;
    int mark;

    String name;
    String instructor;

    double avg,median;
    int min,max;

    public GenerateResults() {
    }

    public GenerateResults(double avg, double median, int min, int max) {
        this.avg = avg;
        this.median = median;
        this.min = min;
        this.max = max;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public GenerateResults(long rollNumber, String name, String instructor, int mark) {
        this.rollNumber = rollNumber;
        this.mark = mark;
        this.name = name;
        this.instructor = instructor;
    }

    public long getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(long rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "rollNumber:" + rollNumber +
                ", mark:" + mark +
                ", name:" + name  +
                ", instructor:" + instructor  +
                ", avg:" + avg +
                ", median:" + median +
                ", min:" + min +
                ", max:" + max +
                '}';
    }
}

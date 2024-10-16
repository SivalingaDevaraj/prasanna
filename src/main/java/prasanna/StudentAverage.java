package prasanna;

public class StudentAverage {
    private String student_name;
    private double average_mark;

    public StudentAverage(String student_name, double average_mark) {
        this.student_name = student_name;
        this.average_mark = average_mark;
    }

    public String getStudent_name() {
        return student_name;
    }

    public double getAverage_mark() {
        return average_mark;
    }
}

import java.util.ArrayList;

public class Student {
    private  String student_name;
    private String student_admission;
    private ArrayList<Course> student_courses = new ArrayList<>();

    public Student(String student_name, String student_admission, ArrayList<Course> student_courses) {
        this.student_name = student_name;
        this.student_admission = student_admission;
        this.student_courses = student_courses;
    }

    public Student(String student_name, String student_admission) {
        this.student_name = student_name;
        this.student_admission = student_admission;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_admission() {
        return student_admission;
    }

    public void setStudent_admission(String student_admission) {
        this.student_admission = student_admission;
    }

    public ArrayList<Course> getStudent_courses() {
        return student_courses;
    }

    public void setStudent_courses(ArrayList<Course> student_courses) {
        this.student_courses = student_courses;
    }
}

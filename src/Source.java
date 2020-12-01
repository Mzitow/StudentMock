import java.util.ArrayList;
import java.util.Scanner;

public class Source {

    static ArrayList<Student> students;
    static ArrayList<Course> courses;
    static boolean exit = false;

    public static void main(String[] args){

        students = new ArrayList<>();
        courses = new ArrayList<>();


        while(!exit){
            System.out.println("Main Menu (Enter your choice)");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Exit");

            int choice = 0;
            Scanner input = new Scanner(System.in);
            choice =  input.nextInt();

            if ((choice == 1) || (choice == 2) || (choice == 3)) {
                switch (choice)
                {
                    case 1:
                        doAdminStuff();
                        break;
                    case 2:
                        doStudentStuff();
                        break;
                    case 3:
                        System.out.println("System Exiting");
                        exit = true;
                        break;
                    default:
                        System.out.println();
                        break;
                }
            } else
            {
                System.out.println("Wrong Choice, Please Try Again");
            }
        }

    }

    private static void doAdminStuff() {
        boolean inAdmin = true;

        while(inAdmin){
            System.out.println("Admin (Enter your choice)");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Remove Student");
            System.out.println("4. Remove Course");
            System.out.println("5. Back <-- ");


            int choice = 0;
            Scanner input = new Scanner(System.in);
            choice =  input.nextInt();

            if ((choice == 1) || (choice == 2) || (choice == 3) || (choice == 4) || (choice == 5)) {
                switch (choice)
                {
                    case 1:
                        System.out.println("1. Add Student: Enter Name and Admission No");
                        addStudent(input.next(),input.next());

                        System.out.println("--------------------------------");
                        printAllStudents(students);
                        System.out.println("---------------------------------");
                        break;
                    case 2:
                        System.out.println("2. Add Course: Enter Course Name and Course Code");
                        addCourse(input.next(),input.next());

                        System.out.println("--------------------------------");
                        printCourses(courses);
                        System.out.println("---------------------------------");
                        break;
                    case 3:
                        System.out.println("3. Remove Student: Enter Index");
                        students.remove((input.nextInt() - 1));

                        System.out.println("--------------------------------");
                        printAllStudents(students);
                        System.out.println("---------------------------------");
                        break;
                    case 4:
                        System.out.println("4. Remove Course : Enter Index");
                        courses.remove((input.nextInt() - 1));

                        System.out.println("--------------------------------");
                        printCourses(courses);
                        System.out.println("---------------------------------");
                        break;
                    case 5:
                        System.out.println("5. Back <-- ");
                        return;
                    default:
                        System.out.println();
                        break;
                }
            } else
            {
                System.out.println("Wrong Choice, Please Try Again");
            }
        }


    }

    private static void doStudentStuff() {

        Scanner input = new Scanner(System.in);

        System.out.println("--------------------------------");
        printAllStudents(students);
        System.out.println("---------------------------------");
        System.out.println();
        System.out.print("Choose Your Index: ");
        int currentStudent = input.nextInt();

        --currentStudent;

        boolean inStudent = true;

        while(inStudent){
            System.out.println("Student (Enter your choice)");
            System.out.println("1. Show Courses");
            System.out.println("2. Register Course");
            System.out.println("3. Withdraw Course");
            System.out.println("4. Back <-- ");


            int choice = 0;

            choice =  input.nextInt();

            if ((choice == 1) || (choice == 2) || (choice == 3) || (choice == 4)) {
                switch (choice)
                {
                    case 1:
                        System.out.println("1. Show Courses: ");
                        System.out.println("--------------------------------");
                        printCourses(students.get(currentStudent).getStudent_courses());
                        System.out.println("--------------------------------");
                        break;
                    case 2:
                        System.out.println("2. Register Course: Enter Index");

                        System.out.println("--------------------------------");
                        printCourses(courses);
                        System.out.println("---------------------------------");

                        int toRegister = input.nextInt();
                        --toRegister;

                        students.get(currentStudent).getStudent_courses().add(courses.get(toRegister));

                        System.out.println("--------------------------------");
                        printCourses(students.get(currentStudent).getStudent_courses());
                        System.out.println("---------------------------------");
                        break;
                    case 3:
                        System.out.println("3. Withdraw Course: Enter Index");

                        System.out.println("--------------------------------");
                        printCourses(students.get(currentStudent).getStudent_courses());
                        System.out.println("---------------------------------");

                        int toWithdraw = input.nextInt();
                        --toWithdraw;

                        students.get(currentStudent).getStudent_courses().remove(toWithdraw);

                        System.out.println("--------------------------------");
                        printCourses(students.get(currentStudent).getStudent_courses());
                        System.out.println("---------------------------------");

                        break;
                    case 4:
                        System.out.println("4. Back <-- ");
                        return;
                    default:
                        System.out.println();
                        break;
                }
            } else
            {
                System.out.println("Wrong Choice, Please Try Again");
            }
        }


    }

    private static Course addCourse(String course_name, String course_code)
    {
        Course newCourse = new Course(course_name, course_code);
        courses.add(newCourse);
        return newCourse;
    }

    private static Student addStudent(String name, String admission_no)
    {
        Student newStudent = new Student(name, admission_no);
        students.add(newStudent);
        return newStudent;
    }

    private static void printAllStudents(ArrayList<Student> students) {
        for (Student x: students) {
            System.out.println("Index: " + (students.indexOf(x) + 1));
            System.out.println("Name: " +  x.getStudent_name());
            System.out.println("Admission: " + x.getStudent_admission());
            printCourses(x.getStudent_courses());
            System.out.println();

        }
    }

    private static void printCourses(ArrayList<Course> courses) {

        for (Course x: courses) {
            System.out.println("Index: " + (courses.indexOf(x) + 1));
            System.out.println("Name: " +  x.getCourse_name());
            System.out.println("Code: " + x.getCourse_code());
            System.out.println();
        }

    }

}

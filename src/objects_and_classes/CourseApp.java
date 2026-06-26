package objects_and_classes;

public class CourseApp {

    public static void main(String[] args) {

    }
}

class Student {

    private String name;
    private float grade;

    public Student() {};

    public Student(String name, float grade) {
        this.name = name;
        this.grade = grade;
    }

    // Setters

    // Getters
}

class Course {

    private String courseName;
    private Student[] students;
    private int studentCount;

    public Course() {}

    public Course(String courseName, Student[] students) {
        this.courseName = courseName;
        this.students = students;
        this.studentCount = students.length;
    }

    //Setters

    //Getters
}

package objects_and_classes;

public class CourseApp {

    public static void main(String[] args) {

        Course javaCourse = new Course("Core Java");

        javaCourse.addStudent(new Student("George", 7.3));
        javaCourse.addStudent(new Student("John", 8.9));
        javaCourse.addStudent(new Student("Helen", 7.8));
        javaCourse.addStudent(new Student("Leyla", 6.3));
        javaCourse.addStudent(new Student("Andrew", 9.2));

        javaCourse.printStudents();
        javaCourse.printAvgGrade();
        javaCourse.printTopStudent();
    }
}

class Student {

    private String name;
    private double grade;

    public Student() {};

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    // Setters
    public void setName(String name) { this.name = name; }

    public void setGrade(double grade) { this.grade = grade; }

    // Getters
    public String getName() { return this.name; }

    public double getGrade() { return this.grade; }
}

class Course {

    private String courseName;
    private Student[] students;
    private int studentCount;

    public Course() {}

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public Course(String courseName, Student[] students) {
        this.courseName = courseName;
        this.students = students;
        this.studentCount = students.length;
    }

    //Setters
    public void setCourseName(String name) { this.courseName = name; }

    public void setStudents(Student[] students) { this.students = students; }

    public void setStudentCount() { this.studentCount = this.students.length; }

    //Getters
    public String getCourseName() { return this.courseName; }

    public Student[] getStudents() { return this.students; }

    public int getStudentCount() { return this.studentCount; }

    // Methods

    // Logic to add a student by prolonging and appending a new student without using List<> and its methods
    public void addStudent(Student student) {
        Student[] newArr = new Student[this.studentCount + 1];
        for (int i=0; i<this.studentCount; i++) {
            newArr[i] = this.students[i];
        }
        newArr[this.studentCount] = student;
        this.students = newArr;
        setStudentCount(); // After computing the new student array we compute thenew length
    }

    // Printing all students existing in the course
    public void printStudents() {
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println("Students Enrolled in The Course:");
        for (Student student : this.students) {
            System.out.printf("- %s\n", student.getName());
        }
    }

    // Printing the average of all the students of the course
    public void printAvgGrade() {
        System.out.println();
        System.out.println("-----------------------------");
        double avgGrade = 0;
        for (Student student : this.students) {
            avgGrade += student.getGrade();
        }
        avgGrade = avgGrade / this.getStudentCount();
        System.out.printf("Average Course Grade is: %.1f", avgGrade);
    }

    // finds and prints the Student that has the highest Grade!
    public void printTopStudent() {
        System.out.println();
        System.out.println();
        System.out.println("------------------------");
        Student topStudent = this.students[0];
        for (Student student : this.students) {
            if (topStudent.getGrade() < student.getGrade()) {
                topStudent = student;
            }
        }
        System.out.printf("Top Student of %s Course is: %s", this.getCourseName(), topStudent.getName());
    }
}

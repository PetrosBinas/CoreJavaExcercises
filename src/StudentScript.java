import java.util.Scanner;

public class StudentScript {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Student stdObj = new Student();
        float[] gradeArr;
        char charGrade;

        stdObj.studentName = getName(sc);
        gradeArr = getGrades(sc);

        stdObj.mathGrade = gradeArr[0];
        stdObj.englishGrade = gradeArr[1];
        stdObj.programmingGrade = gradeArr[2];
        stdObj.studentAverage = stdObj.createAverage();
        charGrade = getCharGrade(stdObj.studentAverage);

        sc.close();

        finalPrint(stdObj.studentName, stdObj.studentAverage, charGrade);

    }

    static String getName(Scanner sc) {

        String studentName;

        while(true) {
            System.out.println("Type Your Name: ");

            studentName = sc.next();

            if (!studentName.isEmpty()){
                return studentName;
            }
        }
    }

    static float[] getGrades(Scanner sc){

        float[] gradeArr = new float[3];
        int pointer = 0;
        int curGrade = 0;

        while ( pointer < 3 ) {
            if (pointer == 0) {
                System.out.println("Type Your Math Grade:");
                curGrade = sc.nextInt();
                if (curGrade >= 0 && curGrade <= 10) {
                    gradeArr[0] = (float) curGrade;
                    pointer++;
                }
            }
            else if (pointer == 1) {
                System.out.println("Type your English Grade:");
                curGrade = sc.nextInt();
                if (curGrade >= 0 && curGrade <= 10) {
                    gradeArr[1] = (float) curGrade;
                    pointer++;
                }
            }
            else {
                System.out.println("Type Your Programming Grade:");
                curGrade = sc.nextInt();
                if (curGrade >= 0 && curGrade <= 10) {
                    gradeArr[2] = (float) curGrade;
                    pointer++;
                }
            }
        }
        return gradeArr;
    }

    static char getCharGrade(float studentAverage) {

        if (studentAverage >= 9.0) { return 'A'; }
        else if (studentAverage >= 8.0) { return 'B'; }
        else if (studentAverage >= 7.0) { return 'C'; }
        else if (studentAverage >= 6.0) { return 'D'; }
        else { return 'F'; }
    }

    static void finalPrint(String name, float gradeAverage, char gradeChar) {

        System.out.printf("%s your grade average is:\n %f\nWhich corresponds to a:\n '%c'", name, gradeAverage, gradeChar);
    }
}

class Student {

    String studentName;
    float mathGrade;
    float englishGrade;
    float programmingGrade;
    float studentAverage;

    float createAverage() {
        float studentAverage;

        studentAverage = (this.mathGrade + this.englishGrade + this.programmingGrade) / 3;

        return studentAverage;
    }

}

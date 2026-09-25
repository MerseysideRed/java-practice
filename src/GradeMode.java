import java.util.Random;

public class GradeMode {

    static void generateGrades(int[] grades, int gradeMax){
        Random random = new Random();

        for (int i = 0; i < grades.length; i++) {
            grades[i] = random.nextInt(1,gradeMax + 1);
        }
    }

    static void printGrades(int[] grades){
        for (int grade : grades) {
            System.out.print(grade + " ");
        }
    }

    static void countGrades(int[] grades, int[]gradeCounts){
        for (int grade : grades){
            gradeCounts[grade]++;
        }
    }

    static void printCounts(int[] gradeCounts){
        for (int grade = 1; grade < gradeCounts.length; grade++) {
            System.out.println(grade + " встречается " + gradeCounts[grade] + " раз");
        }
    }

    static void printModes(int[] gradeCounts){
        int max = 0;

        for (int grade = 1; grade < gradeCounts.length; grade++) {
            if (gradeCounts[grade] > max) {
                max = gradeCounts[grade];
            }
        }

        for (int grade = 1; grade < gradeCounts.length; grade++) {
            if (gradeCounts[grade] == max) {
                System.out.println("Оценка " + grade + " встречается " + max + " раз");
            }
        }
    }

    public static void main(String[] args) {
        final int MAX_GRADE = 5;
        final int TOTAL_GRADES = 25;

        int[] gradeCounts = new int[MAX_GRADE + 1];
        int[] grades = new int[TOTAL_GRADES];

        generateGrades(grades, MAX_GRADE);

        printGrades(grades);

        System.out.println();

        countGrades(grades, gradeCounts);

        printCounts(gradeCounts);

        printModes(gradeCounts);
    }
}

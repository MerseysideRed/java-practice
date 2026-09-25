import java.util.Random;

public class GradeModeFinder {

    static final int TOTAL_GRADES = 25;
    static final int MAX_GRADE = 5;

    static int[] generateGradesArray() {
        Random random = new Random();

        int[] grades = new int[TOTAL_GRADES];

        for (int i = 0; i < grades.length; i++) {
            grades[i] = random.nextInt(1, MAX_GRADE + 1);
        }

        return grades;
    }

    static void printGrades(int[] grades) {
        for (int grade : grades) {
            System.out.print(grade + " ");
        }

        System.out.println();
    }

    static int[] countGrades(int[] grades) {
        int[] gradesCount = new int[MAX_GRADE + 1];

        for (int grade : grades) {
            gradesCount[grade]++;
        }

        return gradesCount;
    }

    static boolean checkGradesCount(int[] gradesCount) {
        int counterGrades = 0;

        for (int count : gradesCount) {
            counterGrades += count;
        }

        return counterGrades == TOTAL_GRADES;
    }

    static int findMaxCount(int[] gradesCount) {
        int maxCount = 0;

        for (int i = 1; i < gradesCount.length; i++) {
            if (gradesCount[i] > maxCount) {
                maxCount = gradesCount[i];
            }
        }

        return maxCount;
    }

    static void printMode(int[] gradesCount, int maxCount) {
        for (int i = 1; i < gradesCount.length; i++) {
            if (gradesCount[i] == maxCount) {
                System.out.println(i + " встречается " + maxCount + " раз");
            }
        }
    }

    public static void main(String[] args) {

        int[] grades = generateGradesArray();

        int[] gradesCount = countGrades(grades);

        printGrades(grades);

        printMode(gradesCount, findMaxCount(gradesCount));

        System.out.println("Все оценки учтены " + checkGradesCount(gradesCount));
    }
}

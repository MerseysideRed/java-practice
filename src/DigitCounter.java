import java.util.Random;

public class DigitCounter {

    static void fillArray(int[] digits){
        Random random = new Random();

        for (int i = 0; i < digits.length; i++) {
            digits[i] = random.nextInt(1,10);
        }
    }

    static void countDigits(int[] digits, int[] digitsCount){
        for (int i = 0; i < digits.length; i++) {
            digitsCount[digits[i]]++;
        }
    }

    static void printDigitsWithTwoAppearances(int[] digitsCount){
        for (int i = 1; i < digitsCount.length; i++) {
            if (digitsCount[i] == 2) {
                System.out.println("Цифра " + i + " встречается 2 раза");
            }
        }
    }

    static int countUniqueDigits(int[] digitsCount){
        int counter = 0;

        for (int i = 1; i < digitsCount.length; i++) {
            if (digitsCount[i] == 1) {
                counter++;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        final int ARRAY_SIZE = 40;
        final int MAX_DIGIT = 9;

        int[] digits = new int[ARRAY_SIZE];
        int[] digitsCount = new int[MAX_DIGIT + 1];

        fillArray(digits);

        countDigits(digits,digitsCount);

        printDigitsWithTwoAppearances(digitsCount);

        System.out.println("Чисел встретившихся один раз " + countUniqueDigits(digitsCount));
    }
}

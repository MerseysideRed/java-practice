import java.util.Random;

public class DigitOccurrencesAnalyzer {
    static final int TOTAL_DIGITS = 40;
    static final int MAX_DIGIT = 9;
    static final int MIN_DIGIT = 1;

    static int[] generateDigitsArray() {
        int[] digitsArray = new int[TOTAL_DIGITS];

        Random random = new Random();

        for (int i = 0; i < digitsArray.length; i++) {
            digitsArray[i] = random.nextInt(MIN_DIGIT, MAX_DIGIT + 1);
        }

        return digitsArray;
    }

    static void printDigitsArray(int[] digitsArray) {
        for (int digit : digitsArray) {
            System.out.print(digit + " ");
        }

        System.out.println();
    }

    static int[] countDigits(int[] digitsArray) {
        int[] digitCounts = new int[MAX_DIGIT + 1];

        for (int digit : digitsArray) {
            digitCounts[digit]++;
        }

        return digitCounts;
    }

    static int[] findDoubleAppearance(int[] digitCounts) {
        int doubleAppearanceArrayLength = 0;

        for (int i = MIN_DIGIT; i < digitCounts.length; i++) {
            if (digitCounts[i] == 2) {
                doubleAppearanceArrayLength++;
            }
        }

        int[] digitsAppearingTwice = new int[doubleAppearanceArrayLength];
        int filledCell = 0;

        for (int i = MIN_DIGIT; i < digitCounts.length; i++) {
            if (digitCounts[i] == 2) {
                digitsAppearingTwice[filledCell] = i;
                filledCell++;
            }
        }

        return digitsAppearingTwice;
    }

    static void printDoubleAppearanceDigits(int[] doubleAppearanceArray) {
        for (int digit : doubleAppearanceArray) {
            System.out.println(digit + " встречается дважды");
        }

    }

    static int findUniqueDigitsQuantity(int[] digitCounts) {
        int uniqueDigitsQuantity = 0;

        for (int i = MIN_DIGIT; i < digitCounts.length; i++) {
            if (digitCounts[i] == 1) {
                uniqueDigitsQuantity++;
            }
        }

        return uniqueDigitsQuantity;
    }

    static void printUniqueDigitsQuantity(int uniqueDigitQuantity) {
        System.out.println("Уникальных значение - " + uniqueDigitQuantity);
    }

    public static void main(String[] args) {
        int[] digitsArray = generateDigitsArray();
        
        printDigitsArray(digitsArray);

        int[] digitCounts = countDigits(digitsArray);

        printDoubleAppearanceDigits(findDoubleAppearance(digitCounts));

        printUniqueDigitsQuantity(findUniqueDigitsQuantity(digitCounts));
    }
}

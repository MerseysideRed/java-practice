import java.util.Random;

public class TestIdGenerator {

    private static final int PRIMARY_ARRAY_LENGTH = 30;
    private static final int RANGE_DIGITS = 21;

    private static int[] returnCountDigitArray(int[] ids) {
        int[] counter = new int[RANGE_DIGITS];

        for (int i = 0; i < ids.length; i++) {
            counter[ids[i]]++;
        }

        return counter;
    }

    static void printDuplicates(int[] ids) {
        int[] counter = returnCountDigitArray(ids);

        for (int j = 0; j < counter.length; j++) {
            if (counter[j] > 1) {
                System.out.println(j + " встречается " + counter[j] + " раз(а)");
            }
        }
    }




    public static void main(String[] args) {
        int[] numbers = new int[PRIMARY_ARRAY_LENGTH];

        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1, RANGE_DIGITS);
            System.out.print(numbers[i] + " ");
        }

        System.out.println();

        printDuplicates(numbers);
        
    }
}

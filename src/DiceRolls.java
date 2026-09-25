import java.util.Random;

public class DiceRolls {

    public static void main(String[] args) {
        int[] faceCounts = new int[7];

        Random random = new Random();

        for (int i = 0; i < 15; i++) {
            int rollValue = random.nextInt(1,7);
            System.out.print(rollValue + " ");
            faceCounts[rollValue]++;
        }

        System.out.println();

        for (int face = 1; face < faceCounts.length; face++) {
            System.out.println("Эта грань " + face + " выпала " + faceCounts[face] + " раз");
        }
    }
}

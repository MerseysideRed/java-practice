import java.util.Random;

public class NewTestIdGenerator {

    static final int ID_ARRAY_LENGTH = 30;
    static final int MAX_ID = 20;

    static int[] generateIdArray() {
        Random random = new Random();

        int[] ids = new int[ID_ARRAY_LENGTH];

        for (int i = 0; i < ids.length; i++) {
            ids[i] = random.nextInt(1, MAX_ID + 1);
        }

        return ids;
    }

    static void printArray(int[] ids) {
        for (int i = 0; i < ids.length; i++) {
            System.out.print(ids[i] + " ");
        }

        System.out.println();
    }

    static int[] countIds(int[] ids) {
        int[] idCounts = new int[MAX_ID + 1];

        for (int i = 0; i < ids.length; i++) {
            idCounts[ids[i]]++;
        }

        return idCounts;
    }

    static void printDuplicates(int[] idCounts) {
        for (int i = 1; i < idCounts.length; i++) {
            if (idCounts[i] > 1) {
                System.out.println("ID " + i + " встречается " + idCounts[i] + " раз(а)");
            }
        }

        System.out.println();
    }

    static int[] removeDuplicates(int[] idCounts, int[] ids) {
        int uniqueIdsCount = 0;

        for (int i = 0; i < idCounts.length; i++) {
            if (idCounts[i] > 0) {
                uniqueIdsCount++;
            }
        }

        int[] uniqueIds = new int[uniqueIdsCount];
        boolean[] isAdded = new boolean[MAX_ID + 1];
        int uniqueIdsIndex = 0;

        for (int i = 0; i < ids.length; i++) {
            if (!isAdded[ids[i]]) {
                uniqueIds[uniqueIdsIndex] = ids[i];
                uniqueIdsIndex++;
                isAdded[ids[i]] = true;
            }
        }

        return uniqueIds;
    }

    public static void main(String[] args) {

        int[] ids = generateIdArray();
        printArray(ids);

        printDuplicates(countIds(ids));

        printArray(removeDuplicates(countIds(ids), ids));

    }
}

public class UniqueCharFinder {

    static final int ALPHABET_SIZE = 26;

    private static int toIndex(char letter) {
        return letter - 'a';
    }

    static Character findUniqueLetter(String text) {
        int[] letterCounts = new int[ALPHABET_SIZE];

        char[] letters = text.toCharArray();

        for (char letter : letters) {
            letterCounts[toIndex(letter)]++;
        }

        for (char letter : letters) {
            if (letterCounts[toIndex(letter)] == 1) {
                return letter;
            }
        }

        return null;
    }

    static void printUniqueLetter(Character uniqueLetter) {
        if (uniqueLetter == null) {
            System.out.println("Уникальных букв нет");
        } else {
            System.out.println(uniqueLetter + " уникальна");
        }
    }

    public static void main(String[] args) {
        String textWithUnique = "abddbac";

        String textWithoutUnique = "aabbb";

        printUniqueLetter(findUniqueLetter(textWithUnique));
        printUniqueLetter(findUniqueLetter(textWithoutUnique));
    }
}

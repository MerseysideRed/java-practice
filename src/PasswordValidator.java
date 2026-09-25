public class PasswordValidator {

    private static boolean isValidLength(String password) {
        return password != null && password.length() >= 8 && password.length() <= 20;
    }

    private static boolean hasDigit(String password) {
        if (password == null) {
            return false;
        }

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasUpperCaseLetter(String password) {
        if (password == null) {
            return false;
        }

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasLowerCaseLetter(String password) {
        if (password == null) {
            return false;
        }

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasNoSpaces(String password) {
        if (password == null) {
            return false;
        }

        for (char c : password.toCharArray()) {
            if (Character.isWhitespace(c)) {
                return false;
            }
        }

        return true;
    }

    static boolean isValidPassword(String password) {
        return (isValidLength(password) && hasDigit(password) && hasUpperCaseLetter(password) && hasLowerCaseLetter(password) && hasNoSpaces(password));
    }

    public static void main(String[] args) {

        String[] passwords = {"12345", "%Lj 12345", "l6&1234456", "Ll3123", "Uh2*232474646464646464646747444", "$Ll12345", "Dgh56ttgdfdf", "JJ12133&45^", "PPf*1223456", "", " "};
        boolean[] expectedResults = {false, false, false, false, false, true, true, false, true, false, false};

        for (int i = 0; i < passwords.length; i++) {
            boolean actual = isValidPassword(passwords[i]);
            String testResult = (actual == expectedResults[i]) ? " PASS" : " FAIL";
            System.out.println(passwords[i] + " " + actual + " " + expectedResults[i] + testResult);
            }
        }
    }

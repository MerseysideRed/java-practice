
public class TestRunAnalyzer {

    private static final int FAILED = 0;
    private static final int PASSED = 1;
    private static final int SKIPPED = 2;
    private static final int BAR_LENGTH = 20;

    private static int countStatus(int[] classResults, int status) {
        int matchCount = 0;

        for (int testResult : classResults) {
            if (testResult == status) {
                matchCount++;
            }
        }

        return matchCount;
    }

    private static void printTestClassResult(String[] testClassesNames, int[][] testResults) {
        for (int i = 0; i < testResults.length; i++) {
            int passedCount = countStatus(testResults[i], PASSED);
            int failedCount = countStatus(testResults[i], FAILED);
            int skippedCount = countStatus(testResults[i], SKIPPED);
            System.out.println("Класс " + testClassesNames[i] + " имеет успешных " + passedCount + " теста, упавших " + failedCount + " теста и пропущенных " + skippedCount + " теста.");
        }
    }

    private static double calculateSuccessPercentage(int passedCount, int testsQuantity) {
        return (double) passedCount / testsQuantity * 100.0;
    }

    private static void printTestClassSuccessPercentage(String[] testClassesNames, int[][] testResults) {
        for (int i = 0; i < testResults.length; i++) {
            int passedCount = countStatus(testResults[i], PASSED);
            double successPercentage = calculateSuccessPercentage(passedCount, testResults[i].length);
            System.out.printf("Класс %s: %.1f%% успеха%n", testClassesNames[i], successPercentage);
        }
    }

    private static void printWorstTestClasses(String[] testClassesNames, int[][] testResults) {
        double[] successPercentages = new double[testResults.length];

        for (int i = 0; i < testResults.length; i++) {
            int passedCount = countStatus(testResults[i], PASSED);
            double successPercentage = calculateSuccessPercentage(passedCount, testResults[i].length);
            successPercentages[i] = successPercentage;
        }

        double worstPercentage = successPercentages[0];

        for (double successPercentage : successPercentages) {
            if (successPercentage < worstPercentage) {
                worstPercentage = successPercentage;
            }
        }

        for (int i = 0; i < successPercentages.length; i++) {
            if (successPercentages[i] == worstPercentage) {
                System.out.printf("Худший класс(ы) %s с значением %.1f%% процентов%n", testClassesNames[i], worstPercentage);
            }
        }
    }

    private static double calculateRunSuccessPercentage(int[][] testResults) {
        int totalPassed = 0;
        int totalTests = 0;

        for (int[] testResult : testResults) {
            totalPassed += countStatus(testResult, PASSED);
            totalTests += testResult.length;
        }

        return calculateSuccessPercentage(totalPassed, totalTests);
    }

    private static void printCommonTestRunResult(int[][] testResults) {
        double commonSuccessPercentage = calculateRunSuccessPercentage(testResults);

        System.out.printf("Общий успех рана %.1f%% процентов%n", commonSuccessPercentage);
    }

    private static String buildProgressBar(double successPercentage) {
        int filledCells = (int) (successPercentage * BAR_LENGTH / 100);

        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < BAR_LENGTH; i++) {
            if (i < filledCells) {
                bar.append('#');
            } else {
                bar.append('-');
            }
        }

        return bar.toString();
    }

    public static void main(String[] args) {
        String[] testClassesNames = {"TestSearch", "TestLogin", "TestPayment", "TestLogout", "TestFilter"};

        int[][] testResults = {
                {2, 2, 2, 0},
                {2, 2, 1},
                {1, 2, 1, 1, 0},
                {1, 1, 0, 1, 2},
                {2, 1, 0}
        };

        printTestClassResult(testClassesNames, testResults);

        printTestClassSuccessPercentage(testClassesNames, testResults);

        printWorstTestClasses(testClassesNames, testResults);

        printCommonTestRunResult(testResults);

        System.out.println(buildProgressBar(calculateRunSuccessPercentage(testResults)));
    }
}

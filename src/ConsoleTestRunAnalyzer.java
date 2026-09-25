public class ConsoleTestRunAnalyzer {
    static final int PASSED = 1;
    static final int FAILED = 0;
    static final int SKIPPED = 2;
    static final int BAR_LENGTH = 20;

    static int countStatus(int[] results, int status) {
        int statusCounter = 0;

        for (int result : results) {
            if (result == status) {
                statusCounter++;
            }
        }

        return statusCounter;
    }

    static double calculateSuccessPercentage(int passed, int total) {
        if (total == 0) {
            return 0;
        }

        return (double) passed / total * 100.0;
    }

    static double calculateClassSuccessPercentage(int[] classResults) {
        int classPassed = countStatus(classResults, PASSED);
        int classTotal = classResults.length;

        return calculateSuccessPercentage(classPassed, classTotal);
    }

    static void printTestClassSummary(int[][] testRunResults, String[] classNames) {
        for (int i = 0; i < testRunResults.length; i++) {
            int passedTests = countStatus(testRunResults[i], PASSED);
            int failedTests = countStatus(testRunResults[i], FAILED);
            int skippedTests = countStatus(testRunResults[i], SKIPPED);
            System.out.printf("Класс %s имеет: %d пройденных тестов, %d упавших тестов, %d пропущенных тестов, процент успеха - %.1f%%%n",
                    classNames[i], passedTests, failedTests, skippedTests, calculateClassSuccessPercentage(testRunResults[i]));
        }
    }

    static int countRunStatus(int[][] testRunResults, int status) {
        int statusCounter = 0;

        for (int[] classResults : testRunResults) {
            statusCounter += countStatus(classResults, status);
        }

        return statusCounter;
    }

    static int countTotalTests(int[][] testRunResults) {
        int totalTests = 0;

        for (int[] classResults : testRunResults) {
            totalTests += classResults.length;
        }

        return totalTests;
    }

    static double calculateRunSuccessPercentage(int[][] testRunResults) {
        int totalPassed = countRunStatus(testRunResults, PASSED);
        int totalTests = countTotalTests(testRunResults);

        return calculateSuccessPercentage(totalPassed, totalTests);
    }

    static void printTestRunSummary(int[][] testRunResults) {
        int totalPassed = countRunStatus(testRunResults, PASSED);
        int totalFailed = countRunStatus(testRunResults, FAILED);
        int totalSkipped = countRunStatus(testRunResults, SKIPPED);
        int totalTests = countTotalTests(testRunResults);

        double totalSuccessPercentage = calculateRunSuccessPercentage(testRunResults);
        System.out.printf("Общая статистика по тест-рану: всего %d тестов, пройденных %d тестов, упавших %d, пропущенных %d, процент успеха - %.1f%%%n",
                totalTests, totalPassed, totalFailed, totalSkipped, totalSuccessPercentage);
    }

    static int findWorstClassIndex(int[][] testRunResults) {
        int worstIndex = 0;
        double worstPercentage = 100.0;

        for (int i = 0; i < testRunResults.length; i++) {
            double classSuccessPercentage = calculateClassSuccessPercentage(testRunResults[i]);
            if (classSuccessPercentage < worstPercentage) {
                worstPercentage = classSuccessPercentage;
                worstIndex = i;
            }
        }

        return worstIndex;
    }

    static void printWorstClass(String[] classNames, int worstIndex) {
        System.out.printf("Класс %s худший%n", classNames[worstIndex]);
    }

    static String buildProgressBar(double percentage) {
        int filledCount = (int) Math.round(percentage / 100 * BAR_LENGTH);
        StringBuilder bar = new StringBuilder();

        for (int i = 0; i < BAR_LENGTH; i++) {
            if (i < filledCount) {
                bar.append("#");
            } else {
                bar.append("-");
            }
        }

        return bar.toString();
    }

    public static void main(String[] args) {
        int[][] testRunResults = {
                {1, 0, 1, 2},
                {1, 0, 1},
                {1, 0, 1, 2, 2},
                {1, 0, 1, 2, 0, 0},
                {1, 0, 1, 2, 1, 1, 1},
        };

        String[] classNames = {"Login", "Search", "Checkout", "Cart", "SKU page"};

        printTestClassSummary(testRunResults, classNames);
        printTestRunSummary(testRunResults);
        printWorstClass(classNames, findWorstClassIndex(testRunResults));
        System.out.println(buildProgressBar(calculateRunSuccessPercentage(testRunResults)));
    }
}

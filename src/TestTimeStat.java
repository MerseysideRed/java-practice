public class TestTimeStat {

    public static void main(String[] args) {
        int[] testDurationMs = {500, 100, 1000, 2000, 3000, 4000, 5000, 900, 2500, 700};

        int min = testDurationMs[0];

        for (int duration : testDurationMs) {
            if (duration < min) {
                min = duration;
            }
        }
        System.out.println("Самый быстрый прогон длился " + min + " миллисекунд");

        int max = testDurationMs[0];

        for (int duration : testDurationMs) {
            if (duration > max) {
                max = duration;
            }
        }
        System.out.println("Самый долгий прогон длился " + max + " миллисекунд");

        double sum = 0.0;

        for (int duration : testDurationMs) {
            sum = sum + duration;
        }
        double averageMs = sum / testDurationMs.length;
        System.out.println("В среднем прогон длился " + averageMs + " миллисекунд");

        final int slowTestRunThresholdMs = 2000;
        for (int i = 0; i < testDurationMs.length; i++) {
            if (testDurationMs[i] > slowTestRunThresholdMs) {
                System.out.println("Медленный прогон " + (i + 1) + " длился " + testDurationMs[i] + " миллисекунд");
            }
        }
    }
}

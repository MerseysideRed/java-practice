import java.util.Scanner;

public class TestRunResults {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Сколько всего тестов?");
        int totalTests = sc.nextInt();

        System.out.println("Сколько тестов прошло?");
        int passedTests = sc.nextInt();
        sc.close();

        if (totalTests <= 0 || passedTests > totalTests || passedTests < 0) {
            System.out.println("Введены некорректные данные");
            return;
        }

        double testRunResultRate = ((double) passedTests / totalTests) * 100.0;
        if (totalTests == passedTests) {
            System.out.println("Отлично, можно релизить");
        } else if (testRunResultRate >= 90.0 && testRunResultRate < 100.0) {
            System.out.println("Требуется анализ падений");
        } else if (testRunResultRate >= 70.0 && testRunResultRate < 90.0) {
            System.out.println("Стоп, разбираемся");
        } else if (testRunResultRate < 70.0) {
            System.out.println("Критическая ситуация");
        }
    }
}

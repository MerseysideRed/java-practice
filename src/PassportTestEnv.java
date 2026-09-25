public class PassportTestEnv {
    public static void main(String[] args) {
        byte build = 1;
        short sprint = 10;
        int teamMembers = 200;
        long quantityOfPassedTests = 20000000L;
        float rateOfJoy = 2.1f;
        double rateOfSadness = 0.1;
        char teamName = 'a';
        boolean permissionToDeploy = true;

        System.out.println("Текущий билд " + build);
        System.out.println("Текущий спринт " + sprint);
        System.out.println("Количество человек в команде " + teamMembers);
        System.out.println("Количество пройденных тестов " + quantityOfPassedTests);
        System.out.println("Рейтинг счастья команды " + rateOfJoy);
        System.out.println("Рейтинг грусти команды " + rateOfSadness);
        System.out.println("Команда " + teamName);
        System.out.println("Разрешение для релиза " + permissionToDeploy);
    }
}

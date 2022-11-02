import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerTemp = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();

        while (userInput != 0) {
            if (userInput == 1) {
                System.out.println("За какой месяц указываете данные? Введите название");
                String userInputMonth = scannerTemp.next();
                System.out.println("За какой день месяца вносим данные? Введите число");
                int userInputTempDay = scannerTemp.nextInt();
                System.out.println("Сколько шагов Вы прошли? Введите число");
                int userInputTempStep = scannerTemp.nextInt();
                stepTracker.getMonthData().get(userInputMonth).setStepDay(userInputTempDay, userInputTempStep);
                converter.printDistance(userInputTempStep);
                converter.printBernKilocalories(userInputTempStep);
                System.out.println("Спасибо, данные записаны!");
            } else if (userInput == 2) {
                System.out.println("За какой месяц необходима статистика? Введите название");
                String userInputMonth = scannerTemp.next();
                System.out.println(stepTracker.getMonthData().get(userInputMonth).sumStepMonth());
                converter.printDistance(stepTracker.getMonthData().get(userInputMonth).sumStepMonth());
                converter.printBernKilocalories(stepTracker.getMonthData().get(userInputMonth).sumStepMonth());
            } else if (userInput == 3) {
                System.out.println("Введите новую ежедневную цель шагов");
                int userInputTempStep = scannerTemp.nextInt();
                stepTracker.setGoalStep(userInputTempStep);
            } else if (userInput == 4) {
                System.out.println("За какой месяц необходима статистика? Введите название");
                String userInputMonth = scannerTemp.next();
                System.out.println(stepTracker.getMonthData().get(userInputMonth).maxStepDay());
            } else if (userInput == 5) {
                System.out.println("За какой месяц необходима статистика? Введите название");
                String userInputMonth = scannerTemp.next();
                System.out.println(stepTracker.getMonthData().get(userInputMonth).averageStepDay());
            } else if (userInput == 6) {
                System.out.println("За какой месяц необходима статистика? Введите название");
                String userInputMonth = scannerTemp.next();
                stepTracker.getMonthData().get(userInputMonth).converter.printDistance(stepTracker.getMonthData().get(userInputMonth).sumStepMonth());
            } else if (userInput == 7) {
                System.out.println("За какой месяц необходима статистика? Введите название");
                String userInputMonth = scannerTemp.next();
                stepTracker.getMonthData().get(userInputMonth).converter.printBernKilocalories(stepTracker.getMonthData().get(userInputMonth).sumStepMonth());
            } else if (userInput == 8) {
                System.out.println("За какой месяц необходима статистика? Введите название");
                String userInputMonth = scannerTemp.next();
                System.out.println(stepTracker.getMonthData().get(userInputMonth).bestDaySerial());
            } else if (userInput == 9) {
                System.out.println("За какой месяц необходима статистика? Введите название");
                String userInputMonth = scannerTemp.next();
                stepTracker.printAllStatMonth(userInputMonth);
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Это счетчик каллорий! Выбирете действие:\n" +
                "1 - Ввести кол-во шагов за день\n" +
                "2 - Напечать статистику за месяц\n" +
                "3 - Изменить цель по кол-ву шагов не день\n" +
                "4 - Максимальное кол-во шагов в месяце\n" +
                "5 - Среднее кол-во шагов в месяце\n" +
                "6 - Пройденная дистация в киломметрах за месяц\n" +
                "7 - Кол-во сожженных каллорий за месяц\n" +
                "8 - Лучшая серия шагов в месяце\n" +
                "9 - Показать полную статистику за месяц\n" +
                "0 - Выйти из приложения");
    }
}

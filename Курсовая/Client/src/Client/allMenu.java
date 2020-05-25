package Client;

import java.util.Scanner;

import static Client.FuncClient.*;

public class allMenu {
    private allMenu(){}

    public static void clearScreen() {
        for (int i = 0; i < 70; i++) {
        System.out.println();
    }

    }

    public static int CommonMenu(String variant[],String type) {
        System.out.printf("===МЕНЮ %s===\n", type);
        for (int i = 0; i < 86; i++) System.out.print("-");
        System.out.println();
        for (int i = 0; i < variant.length; i++) {
            System.out.printf("|%3d|%-80s|",i+1,variant[i]);
            System.out.println();
        }
        for (int i = 0; i < 86; i++) System.out.print("-");
        System.out.println();
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();
        clearScreen();
        int x;
        try {
            x = Integer.parseInt(choice);
        } catch (NumberFormatException e) {
            x = -1;
        }
        if ((x >= 0) && (x <= variant.length)) {
            return x;
        } else return -1;
    }

    public static void firstMenu() {
        boolean a = true;
        while (a) {
            int choice = CommonMenu(new String[]{"Войти в качестве администратора", "Войти в качестве эксперта", "Выход"}, new String("ВХОДА"));
            switch (choice) {
                case 1:
                    Enter("admin");
                    break;
                case 2:
                    Enter("expert");
                    break;
                case 3:
                    exit();
                    a = false;
                    break;
                default:
                    System.out.println("Неверная команда!!!");
                    break;
            }
        }
    }

    public static void adminMenu() {
        boolean a = true;
        while (a) {
            int choice = CommonMenu(new String[]{"Работа со списком оказываемых услуг", "Работа с экспертами", "Работа с целями","Выход"}, new String("АДМИНИСТРАТОРА"));
            switch (choice) {
                case 1:
                    bWorkMenu();
                    break;
                case 2:
                    expertsWorkMenu();
                    break;
                case 3:
                    goalsWorkMenu();
                    break;
                case 4:
                    a = false;
                    break;
                default:
                    System.out.println("Неверная команда!!!");
                    break;
            }
        }
    }

    public static void bWorkMenu() {
        boolean a = true;
        while (a) {
            int choice = CommonMenu(new String[]{"Добавление новой услуги строительной организации", "Удаление существующей услуги", "Просмотр всего списка услуг ","Редактирование описания услуги", "Выход"},new String("РАБОТЫ С УСЛУГАМИ Строительной Организации"));
            switch (choice) {
                case 1:
                    BClient.addB();
                    break;
                case 2:1
                    BClient.deleteB();
                    break;
                case 3:
                    Administrator.showB();
                    break;
                case 4:
                    BClient.changeB();
                    break;
                case 5:
                    a = false;
                    break;
                default:
                    System.out.println("Неверная команда!!!");
                    break;
            }
        }
    }

    public static void expertsWorkMenu() {
        boolean a = true;
        while (a) {
            int choice = CommonMenu(new String[]{"Добавление экперта", "Удаление эксперта", "Просмотр оценок одного эксперта",
                    "Просмотр всех экспертов", "Изменение пароля эксперта", "Выход"},new String("РАБОТЫ С ЭКСПЕРТАМИ"));
            switch (choice) {
                case 1:
                    ExpertWorkClient.addExpert();
                    break;
                case 2:
                    ExpertWorkClient.deleteExpert();
                    break;
                case 3:
                    ExpertWorkClient.findExpert();
                    break;
                case 4:
                    ExpertWorkClient.showExpert();
                    break;
                case 5:
                    ExpertWorkClient.changeExpert();
                    break;
                case 6:
                    a = false;
                    break;
                default:
                    System.out.println("Неверная команда!!!");
                    break;
            }
        }
    }

    public static void goalsWorkMenu() {
        boolean a = true;
        while (a) {
            int choice = CommonMenu(new String[]{"Добавление цели", "Удаление цели", "Просмотр всех целей с описанием",
                    "Просмотр итоговых весов целей","Выход"},new String("РАБОТЫ С ЦЕЛЯМИ"));
            switch (choice) {
                case 1:
                    GoalClient.addGoal();
                    break;
                case 2:
                    GoalClient.deleteGoal();
                    break;
                case 3:
                    Administrator.showGoals();
                    break;
                case 4:
                    Administrator.showResult();
                    break;
                case 5:
                    a = false;
                    break;
                default:
                    System.out.println("Неверная команда!!!");
                    break;
            }
        }
    }

    public static void expertMenu(String login){
        boolean a = true;
        while (a) {
            int choice = CommonMenu(new String[]{"Просмотр всех целей с описанием", "Вынесение оценок по всем целям", "Просмотр списка оказываемых услуг","Выход"}, new String("ЭКСПЕРТА"));
            switch (choice) {
                case 1:
                    Expert.showGoals();
                    break;
                case 2:
                    Expert.newExpertMark(login);
                    break;
                case 3:
                    Expert.showB();
                    break;
                case 4:
                    a = false;
                    break;
                default:
                    System.out.println("Неверная команда!!!");
                    break;
            }
        }
    }
}


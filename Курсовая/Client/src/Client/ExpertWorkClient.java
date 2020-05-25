package Client;

import java.io.IOException;

import static Client.mainClient.*;
import static Client.mainClient.reader;
import static Client.FuncClient.decrypt;
import static Client.FuncClient.encrypt;

public class ExpertWorkClient {
    public static void addExpert() {
        String log, pass1, pass2;

        System.out.println("===РЕГИСТРАЦИЯ ЭКСПЕРТА===");
        System.out.println("-Введите новый логин: ");
        log = reader.nextLine();

        System.out.println("-Введите новый пароль: ");
        pass1 = reader.nextLine();

        System.out.println("-Подтвердите пароль: ");
        pass2 = reader.nextLine();
        if (!pass1.equals(pass2)) {
            System.out.println("Ошибка! Пароли не совпадают!");
            return;
        }

        try {
            StringBuilder message = new StringBuilder("addExpert;");
            message.append(encrypt(log) + ";");
            message.append(encrypt(pass1) + ";");
            out.write(message + System.lineSeparator());
            out.flush();
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showExpert() {
        StringBuilder message = new StringBuilder("showExperts;");
        try {
            out.write(message + System.lineSeparator());
            out.flush();
            String buf = in.readLine();
            System.out.println("ПРОСМОТР ЭКСПЕРТОВ");
            for (int i = 0; i < 83; i++) System.out.printf("-");
            System.out.printf("\n|%-40s|%-40s|\n", "Логин эксперта", "Пароль");
            for (int i = 0; i < 83; i++) System.out.printf("-");
            System.out.println();
            while (!buf.equals(";;")) {
                String part[] = buf.split(";");
                System.out.printf("|%40s|", decrypt(part[0]));
                System.out.printf("%40s|", decrypt(part[1]));
                System.out.println();
                buf = in.readLine();
            }
            for (int i = 0; i < 83; i++) System.out.printf("-");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void findExpert() {
        StringBuilder message = new StringBuilder("findExpert;");
        System.out.println("===ПОИСК ЭКСПЕРТА===");
        System.out.println("-Введите логин экперта: ");
        String log = reader.nextLine();
        message.append(encrypt(log) + ";");
        try {
            out.write(message + System.lineSeparator());
            out.flush();
            String buf = in.readLine();
            if (!buf.equals("")) {
                String part[] = buf.split(";");
                System.out.print("-Логин эксперта:"+ decrypt(part[0]));
                System.out.println();
                System.out.print("-Отметки эксперта:");
                String ratings[] = part[2].split(" ");
                for (int i = 0; i < ratings.length - 1; i++) {
                    System.out.print(ratings[i] + ",");
                }
                System.out.println(ratings[ratings.length - 1]);
            } else {
                System.out.println("Нет пользователя с таким номером!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteExpert() {
        StringBuilder message = new StringBuilder("deleteExpert;");
        System.out.println("===УДАЛЕНИЕ ЭКСПЕРТА===");
        System.out.println("-Введите логин, удаляемого экперта:");
        String log = reader.nextLine();
        message.append(encrypt(log) + ";");
        try {
            out.write(message + System.lineSeparator());
            out.flush();
            System.out.println(in.readLine() + "!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeExpert() {

        StringBuilder message = new StringBuilder("changeExpert;");
        System.out.println("===РЕДАКТИРОВАНИЕ ЭКСПЕРТА===");
        System.out.println("-Введите логин, редактируемого экперта:");
        String log = reader.nextLine();
        System.out.println("-Введите новый пароль эксперта: ");
        String pass = reader.nextLine();

        message.append(encrypt(log) + ";");
        message.append(encrypt(pass) + ";");
        try {
            out.write(message + System.lineSeparator());
            out.flush();
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

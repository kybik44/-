package Client;

import java.io.*;
import static Client.mainClient.*;
import static Client.allMenu.adminMenu;
import static Client.allMenu.expertMenu;


public class FuncClient {


    public static String encrypt(String string) {
        StringBuilder crypton = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                crypton.append((char) (string.charAt(i) - 10));
            } else crypton.append((char) (string.charAt(i) + 10));
        }
        return crypton.toString();
    }

    public static String decrypt(String str) {
        StringBuilder cryptoff = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i) + 10)) {
                cryptoff.append((char) (str.charAt(i) + 10));
            } else cryptoff.append((char) (str.charAt(i) - 10));
        }
        return cryptoff.toString();
    }

    public static void Enter(String type) {
        try {
            String aMessage;
            String login;
            while (true) {
                StringBuilder message = new StringBuilder("authorization;");
                message.append(type);
                message.append(";");
                for (int i = 0; i< 30; i++) System.out.print("-");
                System.out.println();
                System.out.printf("|%27s|","Логин: ");
                System.out.println();
                for (int i = 0; i< 30; i++) System.out.print("-");
                System.out.println();
                login = reader.nextLine();
                message.append(encrypt(login));
                message.append(";");
                for (int i = 0; i< 30; i++) System.out.print("-");
                System.out.println();
                System.out.printf("|%27s|","Пароль: ");
                System.out.println();
                for (int i = 0; i< 30; i++) System.out.print("-");
                System.out.println();
                message.append(encrypt(reader.nextLine()));
                message.append(";");
                out.write(message + System.lineSeparator());
                out.flush();
                aMessage = in.readLine();
                if (aMessage.equals("No")) {
                    System.out.println("Неверный логин или пароль!");
                    System.out.println("Попробовать еще раз?(Нет - 0)");
                    String ans2 = reader.nextLine();
                    if ((!ans2.equals("")) && ((ans2.charAt(0) == '0'))) {
                        break;
                    }
                } else break;
            }
            if (aMessage.equals("Yes")) {
                switch (type) {
                    case "admin":
                        adminMenu();
                        break;
                    case "expert":
                        expertMenu(login);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void exit() {
        try {
            out.write("exit;" + System.lineSeparator());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

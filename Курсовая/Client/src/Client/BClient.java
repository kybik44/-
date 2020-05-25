package Client;

import java.io.IOException;

import static Client.mainClient.*;
import static Client.mainClient.reader;

public class BClient {
    public static void addB() {
        String title, description;
        String deskr;
        System.out.println("-Введите название:");
        title = reader.nextLine();
        System.out.println("-Введите описание :");
        System.out.println("За предыдущий месяц было оказано раз:");
        description = reader.nextLine();
        System.out.println("Прибыль с оказания услуги:");
        deskr = reader.nextLine();
        description= "За предыдущий месяц было оказано раз:"+description+" Прибыль с оказания услуги:"+ deskr;
        try {
            StringBuilder message = new StringBuilder("addB;");
            message.append(title + ";");
            message.append(description + ";");
            out.write(message + System.lineSeparator());
            out.flush();
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteB() {

        StringBuilder message = new StringBuilder("deleteB;");
        System.out.println("===УДАЛЕНИЕ НАИМЕНОВАНИЯ УСЛУГИ===");
        System.out.println("-Введите название удаляемой услуги:");
        String tit = reader.nextLine();
        message.append(tit + ";");
        try {
            out.write(message + System.lineSeparator());
            out.flush();
            System.out.println(in.readLine() + "!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeB() {

        StringBuilder message = new StringBuilder("changeB;");
        String deskr;
        System.out.println("===РЕДАКТИРОВАНИЕ ОПИСАНИЯ УСЛУГИ===");
        System.out.println("-Введите название редактируемой услуги:");
        String title = reader.nextLine();
        System.out.println("-Введите новое описание : ");
        System.out.println("За предыдущий месяц было оказана раз:");
        String description = reader.nextLine();
        System.out.println("Прибыль с оказания услуги:");
        deskr = reader.nextLine();
        description= "За предыдущий месяц было оказана раз:"+description+" Прибыль с оказания услуги:"+ deskr;
        message.append(title + ";");
        message.append(description + ";");
        try {
            out.write(message + System.lineSeparator());
            out.flush();
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

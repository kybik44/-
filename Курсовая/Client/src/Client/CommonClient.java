package Client;

import java.io.IOException;

import static Client.mainClient.*;

public class CommonClient {
    public static void showB() {
        StringBuilder message = new StringBuilder("showB;");
        try {
            out.write(message + System.lineSeparator());
            out.flush();
            String buf = in.readLine();
            System.out.println("===УСЛУГИ===");
            for (int i = 0; i < 154; i++) System.out.printf("-");
            System.out.printf("\n|%-42s|%-109s|\n", "Название услуги", "Описание услуги");
            for (int i = 0; i < 154; i++) System.out.printf("-");
            System.out.println();
            int j = 1;
            while (!buf.equals(";;")) {
                String part[] = buf.split(";");
                System.out.printf("|%d.%40s|%109s|\n", j, part[0], part[1]);
                j++;
                for (int i = 0; i < 154; i++) System.out.printf("-");
                System.out.println();
                buf = in.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void showGoals() {
        StringBuilder message = new StringBuilder("showGoals;");
        try {
            out.write(message + System.lineSeparator());
            out.flush();
            String buf = in.readLine();
            System.out.println("===ПРОСМОТР ЦЕЛЕЙ===");
            for (int i = 0; i < 142; i++) System.out.printf("-");
            System.out.printf("\n|%-40s|%-100s|\n", "Название цели", "Описание цели");
            for (int i = 0; i < 142; i++) System.out.printf("-");
            System.out.println();
            while (!buf.equals(";;")) {
                String part[] = buf.split(";", 5);
                System.out.printf("|%40s|%100s|\n", part[0], part[1]);
                buf = in.readLine();
            }
            for (int i = 0; i < 142; i++) System.out.printf("-");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

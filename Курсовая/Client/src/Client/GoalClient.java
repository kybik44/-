package Client;

import java.io.IOException;

import static Client.mainClient.*;
import static Client.mainClient.reader;

public class GoalClient {
    public static void addGoal() {
        StringBuilder message = new StringBuilder("addGoal;");
        System.out.println("===ДОБАВЛЕНИЕ ЦЕЛИ===");
        String title;
        String description;
        System.out.println("-Введите название цели: ");
        title = reader.nextLine();
        System.out.println("-Введите описание цели: ");
        description = reader.nextLine();
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

    public static void deleteGoal() {
        StringBuilder message = new StringBuilder("deleteGoal;");
        System.out.println("===УДАЛЕНИЕ ЦЕЛИ===");
        System.out.println("-Введите название удаляемой цели: ");
        String title = reader.nextLine();
        message.append(title + ";");
        try {
            out.write(message + System.lineSeparator());
            out.flush();
            System.out.println(in.readLine() + "!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

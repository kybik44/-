package Client;

import java.io.IOException;
import java.util.ArrayList;

import static Client.mainClient.*;
import static Client.FuncClient.encrypt;

public class Expert extends CommonClient{

    public static void newExpertMark(String login) {

        StringBuilder message = new StringBuilder("NewExpMark;");
        try {
            System.out.println("===ВЫСТАВЛЕНИЕ ЭКСПЕРТНЫХ ОЦЕНОК===");
            message.append(encrypt(login) + ";");
            out.write(message + System.lineSeparator());
            out.flush();
            message = new StringBuilder();
            ArrayList<String> title = new ArrayList<>();
            ArrayList<String> description = new ArrayList<>();
            String buf = in.readLine();
            while (!buf.equals(";;")) {
                String part[] = buf.split(";");
                title.add(part[0]);
                description.add(part[1]);
                buf = in.readLine();
            }
            int marks[][] = new int[title.size()][title.size()];
            int N = title.size();
            N = N * (N - 1);
            for (int i = 0; i < title.size(); i++) {
                String t1 = title.get(i);
                String d1 = description.get(i);
                for (int j = i + 1; j < title.size(); j++) {
                    String t2 = title.get(j);
                    String d2 = description.get(j);
                    for(int p=0;p<57;p++) System.out.print("-");
                    System.out.print("Сравниваемые цели:");
                    for(int p=0;p<58;p++) System.out.print("-");
                    System.out.println();
                    System.out.printf("|%30s|%100s|","Цель","Описание");
                    System.out.println();
                    for(int p=0;p<133;p++) System.out.print("-");
                    System.out.println();
                    System.out.printf("|%30s|%100s|",t1,d1);
                    System.out.println();
                    for(int p=0;p<133;p++) System.out.print("-");
                    System.out.println();
                    System.out.printf("|%30s|%100s|",t2,d2);
                    System.out.println();
                    for(int p=0;p<133;p++) System.out.print("-");
                    System.out.println();
                    while (true) {
                        System.out.println("Введите вашу оценку(0.." + N + "): ");
                        String mark = reader.nextLine();
                        int m;
                        try {
                            m = Integer.parseInt(mark);
                            if ((m < 0) || (m > N)) {
                                System.out.println("Неверая оценка!");
                            } else {
                                marks[i][j] = m;
                                marks[j][i] = N - m;
                                break;
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            for (int i = 0; i < title.size(); i++) {
                for (int j = 0; j < title.size(); j++) {
                    message.append(marks[i][j] + " ");
                }
            }

            out.write(message + System.lineSeparator());
            out.flush();
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


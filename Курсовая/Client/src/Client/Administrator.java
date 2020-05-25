package Client;

import javafx.util.Pair;

import java.io.IOException;
import java.util.*;

import static Client.mainClient.*;
import static Client.FuncClient.decrypt;

public class Administrator extends CommonClient{

    public static void showResult() {

        StringBuilder msg = new StringBuilder("showRes;");
        try {
            System.out.println("===РЕЗУЛЬТАТЫ ЭКСПЕРТНОЙ ОЦЕНКИ===");
            out.write(msg + System.lineSeparator());
            out.flush();
            int expAmount = Integer.parseInt(in.readLine());
            int goalsAmount = Integer.parseInt(in.readLine());
            String goals[] = new String[goalsAmount + 1];
            for (int i = 0; i < goalsAmount + 1; i++) {
                goals[i] = in.readLine();
            }
            int marks[][] = new int[goalsAmount][goalsAmount];
            int expGoal[][] = new int[expAmount][goalsAmount];
            String buf = in.readLine();
            int k = 0;
            int sum = 0;
            String expName[] = new String[expAmount];
            int max = 0;
            while (!buf.equals(";;")) {
                String part[] = buf.split(";");
                String ratings[] = part[2].split(" ");
                expName[k] = decrypt(part[0]);
                max = Math.max(max, part[0].length());
                System.out.println("-Оценки эксперта " + expName[k] + ": ");
                for (int i = 0; i < goalsAmount; i++) {
                    for (int j = 0; j < goalsAmount; j++) {
                        if (i * goalsAmount + j < ratings.length) {
                            marks[i][j] = Integer.parseInt(ratings[i * goalsAmount + j]);
                        } else {
                            marks[i][j] = 0;
                        }
                        System.out.printf("%3d ", marks[i][j]);
                        expGoal[k][i] += marks[i][j];
                        sum += marks[i][j];
                    }
                    System.out.println();
                }
                System.out.println();
                k++;
                buf = in.readLine();
            }
            System.out.println();
            int sumGoals[] = new int[goalsAmount];
            System.out.println("ОЦЕНКИ ЦЕЛЕЙ ЭКСПЕРТАМИ");
            for (int i = 0; i < expAmount; i++) {
                System.out.printf("%" + max + "s - ", expName[i]);
                for (int j = 0; j < goalsAmount; j++) {
                    System.out.printf("%4d", expGoal[i][j]);
                    sumGoals[j] += expGoal[i][j];
                }
                System.out.println();
            }
            System.out.println("-Суммарная оценка целей:");
            System.out.printf("%" + (max + 3) + "s", "");
            for (int i = 0; i < goalsAmount; i++) {
                System.out.printf("%4d", sumGoals[i]);
            }
            System.out.println();
            for (int i = 0; i < 50; i++) System.out.printf("-");
            System.out.println();
            System.out.println("===Итоговые веса каждой цели=== ");
            Double x;
            ArrayList<Pair<Double, String>> aMessage = new ArrayList<>();
            for (int i = 0; i < goalsAmount; i++) {
                x = (double) sumGoals[i] / (double) sum;
                String part[] = goals[i].split(";");
                aMessage.add(new Pair(x, part[0]));
                System.out.printf("%3.3f - %s\n", x, part[0]);
            }
            for (int i = 0; i < 50; i++) System.out.printf("-");
            System.out.println();
            System.out.println("===Проверка правильности вычислений===");
            x = (double) sumGoals[0] / (double) sum;
            System.out.printf("Сумма весов всех целей = %3.3f + ",x);
            for (int i = 1; i < goalsAmount -1; i++) {
                x = (double) sumGoals[i] / (double) sum;
                System.out.printf("%3.3f+", x);
            }
            x = (double) sumGoals[goalsAmount -1] / (double) sum;
            System.out.printf("%3.3f = ", x);
            Double res;
            res = 0.0;
            for (int i = 0; i < goalsAmount; i++) {
                x = (double) sumGoals[i] / (double) sum;
                res = res + x;
            }
            System.out.printf("%3.3f;", res);
            System.out.println();
            Comparator<Pair<Double, String>> comparator = new Comparator<Pair<Double, String>>() {
                @Override
                public int compare(Pair<Double, String> o1, Pair<Double, String> o2) {
                    if (o1.getKey() > o2.getKey())
                        return -1;
                    else return 1;
                }
            };

            aMessage.sort(comparator);
            for(int i=0;i<24;i++) System.out.print("=");
            System.out.print("ОТСОРТИРОВННЫЕ ВЕСА ЦЕЛЕЙ");
            for(int i=0;i<24;i++) System.out.print("=");
            System.out.println();
            for (int i = 0; i < goalsAmount; i++) {
                String str = aMessage.get(i).getValue();
                System.out.printf("|%10.3f|%60s|\n", aMessage.get(i).getKey(), str);
            }
            for (int i = 0; i < 73; i++) System.out.printf("-");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

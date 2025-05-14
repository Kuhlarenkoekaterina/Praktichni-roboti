package praktikum;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class diaryApplication {
    public static void noviyZapis(int n, Scanner sc, String[][] schodennik) {
        LocalDateTime time;
        while (true) {
            try {
                System.out.println("Введіть вашу дату");
                System.out.println("Введіть рік:");
                int year = sc.nextInt();
                int month;
                do {
                    System.out.println("Введіть місяць. Місяць має бути між 1 та 12:");
                    month = sc.nextInt();
                } while (month > 12 || month < 1);
                int day;
                do {
                    System.out.println("Введіть день. День має бути між 1 та 31:");
                    day = sc.nextInt();
                    sc.nextLine();
                } while (day > 31 || day < 1);
                time = LocalDateTime.of(year, month, day, 0, 0, 0);
                break;
            } catch (DateTimeException e) {
                System.out.println("Неправильно введено дату");
            }
        }
        System.out.println("Введіть новий запис");
        String text = sc.nextLine();
        schodennik[0][n] = time.toString();
        schodennik[1][n] = text;
        System.out.println("Запис \" " + time + " " + text + " \" введено");
    }

    public static void vivestiSchodennik(String[][] schodennik) {
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 2; i++) {
                System.out.print(schodennik[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void vidalitiZapis(Scanner sc, String[][] schodennik) {
        LocalDateTime time;
        while (true) {
            try {
                System.out.println("Введіть дату для видалення записа");
                System.out.println("Введіть рік:");
                int year = sc.nextInt();
                int month;
                do {
                    System.out.println("Введіть місяць. Місяць має бути між 1 та 12:");
                    month = sc.nextInt();
                } while (month > 12 || month < 1);
                int day;
                do {
                    System.out.println("Введіть день. День має бути між 1 та 31:");
                    day = sc.nextInt();
                    sc.nextLine();
                } while (day > 31 || day < 1);
                time = LocalDateTime.of(year, month, day, 0, 0, 0);
                break;
            } catch (DateTimeException e) {
                System.out.println("Неправильно введено дату");
            }
        }
        for (int i = 0; i < 15; i++) {
            if (schodennik[0][i].equals(time.toString())) {
                schodennik[0][i] = "Місце для дати";
                schodennik[1][i] = "місце для запису";
                System.out.println("Запис видалено");
                return;
            }
        }
        System.out.println("Запис не знайдено");
    }
}

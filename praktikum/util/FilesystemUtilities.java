package praktikum.util;

import java.io.*;

public class FilesystemUtilities {
    public static void zberegtiSchodennik(String[][] schodennik) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("schodennik.txt"))) {
            for (int j = 0; j < 15; j++) {
                for (int i = 0; i < 2; i++) {
                    writer.write(schodennik[i][j] + "\n");
                }
            }
            System.out.println("Щоденник збережено у файл у папці проекту");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено");
        } catch (IOException e) {
            System.out.println("Виникла помилка при записі у файл");
        }
    }

    public static void zavantazhitiSchodennik(String[][] schodennik) {
        try (BufferedReader reader = new BufferedReader(new FileReader("schodennik.txt"))) {
            int n = 0;
            String s = "";
            while (reader.ready()) {
                s = reader.readLine();
                if (n % 2 == 0) {
                    schodennik[0][n / 2] = s;
                } else {
                    schodennik[1][n / 2] = s;
                }
                n++;
            }
            System.out.println("Щоденник завантажено з файлу");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено");
        } catch (IOException e) {
            System.out.println("Виникла помилка при читанні файлу");
        }
    }
}

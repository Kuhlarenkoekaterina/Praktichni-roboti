package praktikum;

import java.util.Scanner;
import static praktikum.util.FilesystemUtilities.*;
import static praktikum.diaryApplication.*;

public class Main {
    public static String[][] schodennik = new String[2][15];
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            schodennik[0][i] = "Місце для дати";
            schodennik[1][i] = "місце для запису";
        }
        boolean schodennikVidkrito = true;
        int n = 0;
        while (schodennikVidkrito) {
            System.out.println("Виберіть дію:");
            System.out.println("1. Зробити новий запис");
            System.out.println("2. Прочитати щоденник");
            System.out.println("3. Видалити запис за датою");
            System.out.println("4. Завантажити щоденник з файлу");
            System.out.println("5. Вимкнути програму");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    if (n < 15) {
                        noviyZapis(n, sc, schodennik);
                        n++;
                    } else {
                        System.out.println("У щоденнику закінчилось місце");
                    }
                    break;
                case 2:
                    vivestiSchodennik(schodennik);
                    break;
                case 3:
                    vidalitiZapis(sc, schodennik);
                    n--;
                    break;
                case 4:
                    zavantazhitiSchodennik(schodennik);
                    break;
                case 5:
                    schodennikVidkrito = false;
                    System.out.println("Введіть \"Так\" якщо хочете зберегти щоденник");
                    sc.nextLine();
                    if (sc.nextLine().equals("Так")){
                        zberegtiSchodennik(schodennik);
                    }
                    break;
            }
        }
    }
}
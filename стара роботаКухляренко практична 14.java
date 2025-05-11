import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static String[][] schodennik = new String[50][3];
    public static int nomerZapisu = 0;

    public static void noviyZapis() {
        if (nomerZapisu >= 49) {
            System.out.println("У щоденнику закінчилось місце");
        } else {
            System.out.println("Положення показчика щоденника: " + (nomerZapisu + 1));
            System.out.println("Введіть дату у форматі день.місяць.рік, все числами");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String vvedenaData1 = scanner.nextLine();
            LocalDate vvedenaData = LocalDate.parse(vvedenaData1, formatter);
            System.out.println("Введіть запис для цієї дати");
            String vvedenniyText = scanner.nextLine();
            schodennik[nomerZapisu][1] = " "+vvedenaData.toString()+" ";
            schodennik[nomerZapisu][2] = vvedenniyText;
            System.out.println("Запис успішно додано!");
            nomerZapisu++;
        }
    }

    public static void stertiZapis() {
        System.out.println("Введіть номер запису що хочете видалити");
        int entryToBeDeleted = 0;
        do {
            System.out.println("Номер повинен бути між 1 та 50:");
            entryToBeDeleted = scanner.nextInt();
        } while (entryToBeDeleted > 50 || entryToBeDeleted < 0);
        schodennik[entryToBeDeleted - 1][1] = null;
        schodennik[entryToBeDeleted - 1][2] = null;
        System.out.println("Запис і дату успішно видалено!");
        scanner.nextLine();
    }

    public static void prochitati() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Arrays.toString(schodennik[i]));
        }
    }

    public static void zberegtiSchodennik() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("schodennik.txt"))){
            for (int i = 0; i < 50; i++) {
                for (int j = 0; j < 3; j++) {
                    writer.write(schodennik[i][j]);
                }
                writer.write("\n");
            }
            System.out.println("Щоденник успішно записано в файл!");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено!" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при запису в файл");
        } catch (NullPointerException e){
        }
        System.out.println("Щоденник успішно збережено");
    }

    public static void zagruzitiSchodennik() {
        try (BufferedReader reader = new BufferedReader(new FileReader("schodennik.txt"))) {
            String s = "";
            System.out.println("Записи з щоденника: \n");
            int i = 0;
            int j = 1;
            while (reader.ready()) {
                s = reader.readLine();
                System.out.println(s);
                schodennik[i][0] = Integer.toString(j);
                if (i > 9) {
                    schodennik[i][1] = s.substring(3, 13);
                    schodennik[i][2] = s.substring(14);
                } else {
                    if(!s.isEmpty()){
                        schodennik[i][1] = s.substring(2, 12);
                        schodennik[i][2] = s.substring(13);
                    }
                    else{
                        schodennik[i][1] = "";
                        schodennik[i][2] = "";
                    }
                }
                i++;
                j++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено! " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при зчитуванні з файлу");
        } catch (StringIndexOutOfBoundsException e){
        }
    }

    public static void main(String[] args) {
        boolean programaPracyue = true;
        for (int i = 0; i <= 49; i++) {
            schodennik[i][0] = Integer.toString(i + 1);
            schodennik[i][1] = "";
            schodennik[i][2] = "";
        }
        while (programaPracyue) {
            System.out.println("Виберіть опцію:");
            System.out.println("1. Новий запис");
            System.out.println("2. Вивести всі записи");
            System.out.println("3. Видалити запис");
            System.out.println("4. Прочитати та завантажити існуючий щоденник");
            System.out.println("5. Зберегти щоденник у файл");
            System.out.println("6. Вимкнути програму");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    noviyZapis();
                    break;
                case "2":
                    prochitati();
                    break;
                case "3":
                    stertiZapis();
                    break;
                case "4":
                    zagruzitiSchodennik();
                    break;
                case "5":
                    System.out.println("Зберегти щоденник? Так/Ні");
                    if (scanner.nextLine().equals("Так")) {
                        zberegtiSchodennik();
                    }
                    break;
                case "6":
                    System.out.println("Програма вимикається");
                    scanner.close();
                    programaPracyue = false;
                    break;
            }
        }
    }
}

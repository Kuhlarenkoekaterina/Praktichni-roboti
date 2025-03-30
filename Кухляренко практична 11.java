import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static FileWriter zapisuvachUFile = null;
    public static FileReader zchituvachFile = null;
    public static boolean programaPraciue = true;
    public static Scanner scanner = new Scanner(System.in);

    public static void zapisFile() {
        System.out.println("Файл буде створено / буде записано у файл за шляхом " + System.getProperty("user.dir"));
        try {
            zapisuvachUFile = new FileWriter("textFile.txt", true);
            System.out.println("Введіть строку для запису в файл:");
            scanner.nextLine();
            String nastupniyVvid = scanner.nextLine();
            zapisuvachUFile.write(nastupniyVvid + "\n");
            System.out.println("Рядок(рядки) успішно записано в файл!");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено!" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при запису в файл");
        } finally {
            try {
                if (zapisuvachUFile != null) {
                    zapisuvachUFile.close();
                }
            } catch (IOException e) {
                System.out.println("Виникла помилка при закритті файлу");
            }
        }
    }
    public static void prochitatiFile() {
        System.out.println("Буде зчитано з файлу за шляхом " + System.getProperty("user.dir"));
        try {
            zchituvachFile = new FileReader("textFile.txt");
            String fileText = "";
            System.out.println("Текст з файлу: \n");
            while (zchituvachFile.ready()) {
                fileText += (char) zchituvachFile.read();
            }
            System.out.println(fileText);
            System.out.println("Успішно зчитано з файлу!");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено! " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при зчитуванні з файлу");
        } finally {
            try {
                if (zchituvachFile != null) {
                    zchituvachFile.close();
                }
            } catch (IOException e) {
                System.out.println("Виникла помилка при закритті файлу");
            }
        }
    }

    public static void vimknutiProgramu() {
        programaPraciue = false;
        scanner.close();
    }

    public static void vivestiMenu() {
        System.out.println("Оберіть дію: 1 - Запис у файл; 2 - Зчитування з файлу; 3 -Вихід з програми");
    }

    public static void main(String[] args) {
        while (programaPraciue) {
            vivestiMenu();
            int input;
            while (true) {
                try {
                    input = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Будь ласка, вводіть тільки цифри!");
                    vivestiMenu();
                    scanner.next();
                }
            }
            switch (input) {
                case 1:
                    zapisFile();
                    break;
                case 2:
                    prochitatiFile();
                    break;
                case 3:
                    vimknutiProgramu();
                    break;
            }
        }
    }

}
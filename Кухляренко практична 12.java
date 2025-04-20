import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static boolean programaPracyue = true;

    public static void zapisatiUFile() {
        System.out.println("Файл буде створено / буде записано у файл за шляхом " + System.getProperty("user.dir"));
        System.out.println("Введіть кількість рядків, що будете вводити:");
        int n;
        while (true) {
            try {
                n = sc.nextInt();
                sc.nextLine();
                if (n < 1) {
                    System.out.println("Будь ласка, вводіть тільки натуральні числа!");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Будь ласка, вводіть тільки натуральні числа!");
                sc.next();
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt", true));) {
            System.out.println("Введіть рядок(рядки) для запису в файл:");
            int j = kilkistStrok()+1;
            for (int i = 0; i < n; i++) {
                System.out.print((j + ". "));
                String nextEntry = sc.nextLine();
                writer.write(nextEntry + "\n");
                j++;
            }
            System.out.println("Рядок(рядки) успішно записано в файл!");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено!" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при запису в файл");
        }
    }

    public static int kilkistStrok(){
        int i=0;
        try (BufferedReader countLine = new BufferedReader(new FileReader("file.txt"))) {
            while(countLine.readLine() != null){
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено! " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при рахуванні рядків з файлу");
        }
        return i;
    }

    public static void vivestiMenu() {
        System.out.println("Оберіть дію:");
        System.out.println("1. Новий запис у файл");
        System.out.println("2. Прочитати файл");
        System.out.println("3. Вийти з програми");
    }

    public static void prochitatiFile() {
        System.out.println("Буде зчитано з файлу за шляхом " + System.getProperty("user.dir"));
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            int j = kilkistStrok();

            System.out.println("Введіть нижню частину діапазону для виводу рядків (всього рядків у файлі: " + j + ") . Введіть 0 що б вивести весь файл.");
            int input = 0;
            do{
                input = sc.nextInt();
            }while(input>j);

            if(input == 0){
                String s = "";
                System.out.println("Текст з файлу: \n");
                int i = 0;
                while (reader.ready()) {
                    i++;
                    s = reader.readLine();
                    System.out.println(i + ". " + s);
                }
            }
            else{
                int lower = input;
                System.out.println("Нижня частина діапазона введена! Введіть верхню:");
                do{
                    input = sc.nextInt();
                }while(input>j);
                int upper = input;
                System.out.println("Верхня частина діапазона введена!");
                System.out.println("Текст з файлу з " + lower + " по " + upper + "рядки");
                String s = "";
                int i = 0;
                while (reader.ready()) {
                    i++;
                    if(i >= lower && i <= upper){
                        s = reader.readLine();
                        System.out.println(i + ". " + s);
                    }
                    if(i>upper){
                        break;
                    }
                }
            }
            System.out.println("\n");
            System.out.println("Успішно зчитано з файлу! Перехід до меню...");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено! " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при зчитуванні з файлу");
        }
    }

    public static void vimknutiProgramu() {
        programaPracyue = false;
        sc.close();
    }

    public static void main(String[] args) {
        while (programaPracyue) {
            vivestiMenu();
            int input;
            input = sc.nextInt();
            switch (input) {
                case 1:
                    zapisatiUFile();
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
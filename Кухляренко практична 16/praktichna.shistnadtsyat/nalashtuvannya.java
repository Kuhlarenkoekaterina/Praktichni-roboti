package praktichna.shistnadtsyat;

import java.io.*;
import java.util.Scanner;

public class nalashtuvannya {
    public static int nalashtuvannia(Scanner sc, int choice, int size){
        do{
            System.out.println("Введіть розмір 3,5,7 чи 9");

            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Не підтримується");
            }
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) {
                break;
            }
            else{
                size = choice;
            }
        }
        while (choice < 3 || choice > 9 || choice%2 == 0);
        return size;
    }

    public static void zberegtiNalashtuvannya (int size){
        System.out.println("Налаштування збережено у папці проекту");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("nalashtuvannia.txt"))) {
            writer.write(size + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено!" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при запису в файл");
        }
    }

    public static int zagruzitiNalashtuvannya (int size){
        try (BufferedReader reader = new BufferedReader(new FileReader("nalashtuvannia.txt"))) {
            size = Integer.parseInt(reader.readLine());
            return size;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено!" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при зчитуванні файлу");
        }
        return 0;
    }
}

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static String[][] schodennik = new String[50][3];
    public static int nomerZapisu = 0;

    public static void noviyZapis(){
        if (nomerZapisu >= 49) {
            System.out.println("У щоденнику закінчилось місце");
        }
        else{
            System.out.println("Номер записа що буде зроблено: " + (nomerZapisu+1));
            System.out.println("Введіть дату у форматі дд.мм.рррр");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate vvedenaData = LocalDate.parse(scanner.nextLine(), formatter);
            System.out.println("Введіть запис для цієї дати");
            String vvedenniyText = scanner.nextLine();
            schodennik[nomerZapisu][1] = vvedenaData.toString();
            schodennik[nomerZapisu][2] = vvedenniyText;
            System.out.println("Запис успішно додано!");
            nomerZapisu++;
        }
    }

    public static void stertiZapis(){
        System.out.println("Введіть номер запису що хочете видалити");
        int entryToBeDeleted = 0;
        do{
            System.out.println("Номер повинен бути між 1 та 50:");
            entryToBeDeleted = scanner.nextInt();
        }while(entryToBeDeleted > 50 || entryToBeDeleted < 0);
        schodennik[entryToBeDeleted-1][1] = null;
        schodennik[entryToBeDeleted-1][2] = null;
        System.out.println("Запис і дату успішно видалено!");
        scanner.nextLine();
    }

    public static void prochitati(){
        for(int i = 0; i<50; i++){
            System.out.println(Arrays.toString(schodennik[i]));
        }
    }

    public static void main(String[] args) {
        boolean programaPracyue = true;
        for (int i = 0; i<=49; i++){
            schodennik[i][0] = Integer.toString(i+1);
        }
        while(programaPracyue) {
            System.out.println("Виберіть опцію:");
            System.out.println("1. Новий запис");
            System.out.println("2. Вивести всі записи");
            System.out.println("3. Видалити запис");
            System.out.println("4. Вимкнути програму");
            String input = scanner.nextLine();
            switch(input){
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
                    System.out.println("Програма вимикається");
                    scanner.close();
                    programaPracyue = false;
                    break;
            }
        }
    }
}
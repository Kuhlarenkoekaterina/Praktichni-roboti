import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static String [][] schodennik = new String[2][15];
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        for(int i = 0; i<15; i++){
                schodennik[0][i] = "Місце для дати";
                schodennik[1][i] = "місце для запису";
        }
        boolean schodennikVidkrito = true;
        int n = 0;
        while(schodennikVidkrito) {
            System.out.println("Виберіть дію:");
            System.out.println("1. Зробити новий запис");
            System.out.println("2. Прочитати щоденник");
            System.out.println("3. Видалити запис за датою");
            System.out.println("4. Вимкнути програму");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    if(n<15){
                        noviyZapis(n);
                        n++;
                    }
                    else{
                        System.out.println("У щоденнику закінчилось місце");
                    }
                    break;
                case 2:
                    vivestiSchodennik();
                    break;
                case 3:
                    vidalitiZapis();
                    n--;
                    break;
                case 4:
                    schodennikVidkrito = false;
                    break;
            }
        }
    }

    public static void noviyZapis(int n){
        LocalDateTime time;
        while(true) {
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
        System.out.println("Запис \" " + time + "    " + text + " \" введено");
    }

    public static void vivestiSchodennik(){
        for(int j = 0; j < 15; j++){
            for(int i = 0; i<2; i++){
                System.out.print(schodennik[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void vidalitiZapis(){
        LocalDateTime time;
        while(true) {
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
        for(int i = 0; i<15; i++){
            if(schodennik[0][i].equals(time.toString())){
                schodennik[0][i] = "Місце для дати";
                schodennik[1][i] = "місце для запису";
                System.out.println("Запис видалено");
                return;
            }
        }
        System.out.println("Запис не знайдено");
    }
}
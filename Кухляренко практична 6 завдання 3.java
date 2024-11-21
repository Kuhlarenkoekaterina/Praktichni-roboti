import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class task3 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть розмір масиву: ");
        int size = sc.nextInt();

            int[] values = new int[size];
            for (int i=0; i<size; i++) {
                values[i] = r.nextInt(1000);
            }
            System.out.println("Масив: ");
            System.out.println(Arrays.toString(values));

            System.out.println("Введіть число для заміни: ");
            int number1 = sc.nextInt();

            System.out.println("Введіть число на яке бажаєте замінити обране: ");
            int number2 = sc.nextInt();
            for (int i = 0; i < size; i++) {
                if (number1 == values[i]) {
                    values[i] = number2;
                }
            }
            System.out.println("Масив з числом " + number1 + " заміненим на " + number2);
            System.out.println(Arrays.toString(values));
    }
}

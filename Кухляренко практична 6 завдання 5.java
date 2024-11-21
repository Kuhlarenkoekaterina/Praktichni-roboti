import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.print("Введіть розмір масиву: ");
        int size = sc.nextInt();

        int[] array = new int[size];
        for (int i=0; i<size; i++) {
            array[i] = r.nextInt(100);
        }
        System.out.println("Масив: ");
        System.out.println(Arrays.toString(array));
        String array1 = "";

        System.out.println("Введіть 1 якщо хочете перевірити масив на спадання та 2 якщо на зростання: ");
        int oneOrTwo = sc.nextInt();
        if (oneOrTwo == 1) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    array1 = "Масив зростає";
                } else {
                    array1 = "Масив не зростає";
                    break;
                }
            }
        }
        else if (oneOrTwo == 2){
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    array1 = "Масив спадає";
                } else {
                    array1 = "Масив не спадає";
                    break;
                }
            }
        }
        else {
            System.out.println("Ви ввели не те число");
        }
        System.out.println(array1);
    }
}

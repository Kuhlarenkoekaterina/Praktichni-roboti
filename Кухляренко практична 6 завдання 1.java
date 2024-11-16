import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class task1 {
        public static void main(String[] args) {
            Scanner scnr = new Scanner(System.in);
            Random rand = new Random();
            System.out.println("Введіть розмір масиву:");
            int size = scnr.nextInt();
            int[] numbers = new int [size];
            int oddAmount = 0;
            int evenAmount = 0;
            for (int i=0; i<size; i++){
                numbers[i] = rand.nextInt(100);
                if (numbers[i] % 2 == 0){
                    evenAmount++;
                }
                else{
                    oddAmount++;
                }
            }
            System.out.println(Arrays.toString(numbers));
            System.out.println("Кількість парних чисел: " + evenAmount);
            System.out.println("Кількість непарних чисел: " + oddAmount);
        }
    }
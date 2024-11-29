import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class task4 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмір матриці: ");
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        System.out.println("Матриця:");
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = random.nextInt(1000);
            }
        }
        for (int i = 0; i < size; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.print("Введіть номер рядка мінор без якого хочете отримати: ");
        int rowExtra = scanner.nextInt()-1;
        System.out.print("Введіть номер стовпця мінор без якого хочете отримати: ");
        int colExtra = scanner.nextInt()-1;

        int[][]small = new int[size - 1][size - 1];
        int a = 0;
        for (int row = 0; row < size; row++) {
            if (row == rowExtra) {
            } else {
                int b = 0;
                for (int col = 0; col < size; col++) {
                    if (col == colExtra) {
                    }
                    else {
                        small[a][b] = matrix[row][col];
                        b++;
                    }
                }
                a++;
            }
        }
        System.out.println("Мінор матриці після виключення рядка і стовпця:");
        for (int i = 0; i < small.length; i++) {
            System.out.println(Arrays.toString(small[i]));
        }
    }
}

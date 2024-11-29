import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class task5 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмір матриці: ");
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];

        System.out.println("Згенерована матриця:");
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = random.nextInt(1000);
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println("Транспонована матриця:");
        int[][] transposed = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                transposed[row][col] = matrix[col][row];
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}

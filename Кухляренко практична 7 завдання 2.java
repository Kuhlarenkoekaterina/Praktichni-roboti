import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

public class task2 {
    public static void main(String[] args) {
        double[][] array = new double[5][5];
        Random generator = new Random();
        System.out.println("Початковий масив:");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = generator.nextDouble();
            }
            System.out.println(Arrays.toString(array[i]));
        }

        System.out.println("Масив після заміни непарних елементів на їх квадратні корені:");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i % 2 != 0) {
                    array[i][j] = Math.sqrt(array[i][j]);
                }
                else if (j % 2 != 0){
                    array[i][j] = Math.sqrt(array[i][j]);
                }
            }
            System.out.println(Arrays.toString(array[i]));
        }
    }
}

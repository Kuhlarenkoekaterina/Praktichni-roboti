import java.util.Scanner;
import java.util.Arrays;

public class zavdannia1 {
    public static void main(String[] args) {
        System.out.print("Введіть висоту піраміди: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] pyramid = new int[n][];
        for (int i = 0; i<pyramid.length; ++i){
            pyramid[i] = new int[i+1];
            for (int j=0; j<pyramid[i].length; ++j){
                pyramid[i][j] = i/(j+1);
            }
        }

        System.out.println("Піраміда (звичайний порядок):");
        for (int i = 0; i < pyramid.length; i++) {
            for (int j = 0; j < pyramid.length - i - 1; j++) { //Центрую рядок
                System.out.print(" ");
            }
            System.out.println(Arrays.toString(pyramid[i]));
        }
        System.out.println("Піраміда (зворотний порядок):");
        for (int i = pyramid.length - 1; i >= 0; i--) {
            for (int j = 0; j < pyramid.length - i - 1; j++) { //Центрую рядок
                System.out.print(" ");
            }
            System.out.println(Arrays.toString(pyramid[i]));
        }
        scanner.close();
    }
}

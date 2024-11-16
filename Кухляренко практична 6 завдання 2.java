import java.util.Scanner;
public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість кутів: ");
        int angles_amount = scanner.nextInt();
        if (angles_amount >= 3) {
            int[] angles = new int[angles_amount];
            int sumOfAngles = 0;
            System.out.println("Введіть кути:");
            for (int i = 0; i < angles_amount; i++) {
                angles[i] = scanner.nextInt();
                sumOfAngles += angles[i];
            }
            int rightSum = 180 * (angles_amount - 2);
            if (sumOfAngles == rightSum) {
                System.out.println("Багатокутник може існувати");
            } else {
                System.out.println("Багатокутник не може існувати");
            }
            System.out.println("Сума кутів: " + sumOfAngles);
            System.out.println("Сума кутів, при якій багатокутник існує: " + rightSum);
        }
        else {
            System.out.println("Багатокутник має містити як мінімум 3 кути");
        }
    }
}

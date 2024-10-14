import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть першу сторону");
        int a = sc.nextInt();
        System.out.println("Введіть другу сторону");
        int b = sc.nextInt();
        System.out.println("Введіть третю сторону");
        int c = sc.nextInt();

        if (a < b + c && b < a + c && c < a + b) {
            System.out.println("Може існувати");
            if (a == b && a == c) {
                System.out.println("Трикутник рівнобічний");
            } else if (a == b || a == c) {
                System.out.println("Трикутник рівнобедренний");
            } else {
                System.out.println("Трикутник різнобічний");
            }}
        else{
            System.out.println("Не може існувати");
        }
    }
}

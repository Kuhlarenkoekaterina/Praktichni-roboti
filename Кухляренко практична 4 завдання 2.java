import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть ціле число");
        int a = sc.nextInt();
        int mirror_a=0;
        int dovzhina = 0;
        int b = a;
        while(b != 0)
        {
            b = b / 10;
            dovzhina = dovzhina + 1;
        }
        for(;a != 0;)
        {
            int ostacha = a % 10;
            mirror_a = mirror_a * 10 + ostacha;
            a=a/10;
        }
        System.out.printf("Відзеркалене число: %0" + dovzhina + "d%n", mirror_a);
    }
    }

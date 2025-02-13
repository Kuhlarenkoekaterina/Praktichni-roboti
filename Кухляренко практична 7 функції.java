import java.util.Scanner;

public class Main {

    public static String dzerkalo1(String stroka) {
        String strokaVidzerkalenna = "";
        for (int i = stroka.length() - 1; i >= 0; i--) {
            strokaVidzerkalenna += (stroka.charAt(i));
        }
        return strokaVidzerkalenna;
    }

    public static String dzerkalo2(String stroka) {
        String strokaVidzerkalenna = "";
        String[] string = stroka.split(" ");
        for (int i = 0; i<string.length; i++) {
            strokaVidzerkalenna += dzerkalo1(string[i]) + " ";
        }
        return strokaVidzerkalenna;
    }

    public static boolean dvaSlova() {
        System.out.println("Введіть 2 слова(3 символи на слово):");
        Scanner scanner = new Scanner(System.in);
        String strokaSlova = scanner.nextLine().trim();
        return strokaSlova.indexOf(' ') > 2 && strokaSlova.length() - strokaSlova.lastIndexOf(' ') > 3;
    }

    public static void main(String[] args) {
        boolean isValid;
        do {
            isValid = dvaSlova();
        } while (!isValid);
        Scanner scanner = new Scanner(System.in);
        System.out.println("2 слова введено!");
        System.out.println("Введіть строку для відзеркалення:");
        String stroka = scanner.nextLine();
        System.out.println("Введіть 0 для відзеркалення строки. Введіть будь яке число для відзеркалення слів:");
        int choice;
        choice = scanner.nextInt();
        if (choice == 0) {
            System.out.println("Відзеркаленна строка:");
            System.out.println(dzerkalo1(stroka));
        } else {
            System.out.println("Відзеркаленна строка, по словам:");
            System.out.println(dzerkalo2(stroka));
        }
    }
}
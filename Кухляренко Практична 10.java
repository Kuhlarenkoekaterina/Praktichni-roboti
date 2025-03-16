import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static String[][] bazaKoristuvachiv = new String[16][2];
    public static Scanner scanner = new Scanner(System.in);
    public static char[] specialniSimvoli = new char[25];
    public static char[] simvoli = new char[95];
    public static boolean loginUspishniy;
    public static int nomerKoristuvacha;
    public static void dobavitiKoristuvacha() {
        vividBaziKoristuvachiv();
        System.out.println("Введіть номер вільної клітинки");
        int obraneChislo = 0;
        try {
            obraneChislo = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Вводіть тільки числа");
        }
        System.out.println("Введіть ім'я нового користувача");
        bazaKoristuvachiv[obraneChislo - 1][0] = obraneChislo + ". " + otrimatiImya() + " ";
        System.out.println("Введіть пароль нового користувача");
        bazaKoristuvachiv[obraneChislo - 1][1] = obraneChislo + ". " + otrimatiParol();
        vividBaziKoristuvachiv();
    }
    public static void vidalitiKoristuvacha(){
        vividBaziKoristuvachiv();
        System.out.println("Введіть номер користувача для видалення:");
        int numberChosen = scanner.nextInt();
        if(bazaKoristuvachiv[numberChosen - 1][0].equals(numberChosen + ". empty ")){
            System.out.println("Користувача не існує");
        }else{
            bazaKoristuvachiv[numberChosen - 1][0] = numberChosen + ". empty ";
            System.out.println("Користувача видалено");
        }
    }
    public static boolean login(){
        scanner.nextLine();
        System.out.println("Введіть ім'я користувача");
        String input = scanner.nextLine();
        int userID =-1;
        for(int i = 0; i<15; i++){
            if (bazaKoristuvachiv[i][0].equals(i+1 + ". " + input + " ")){
                userID = i;
            }
        }
        if (userID == -1){
            System.out.println("Ім'я не знайдено");
            return false;
        }
        while (true) {
            try {
                System.out.println("Введіть пароль:");
                if (bazaKoristuvachiv[userID][1].equals(userID+1 + ". " + scanner.nextLine())) {
                    System.out.println("Ви успішно залогінились");
                    System.out.println("Оберіть дію для вашого користувача");
                    return true;
                } else {
                    System.out.println("Неправильний пароль");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Введена строка пуста. Спробуйте знову");
            }
        }
    }
    public static void loggedIn(){
        do {
        System.out.println("1. Змінити ім'я");
        System.out.println("2. Змінити пароль");
        System.out.println("3. Разлогінитись");
            try {
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("Введіть нове ім'я");
                        bazaKoristuvachiv[nomerKoristuvacha][0] = nomerKoristuvacha + 1 + ". " + otrimatiImya() + " ";
                        break;
                    case 2:
                        System.out.println("Введіть новий пароль");
                        bazaKoristuvachiv[nomerKoristuvacha][1] = nomerKoristuvacha + 1 + ". " + otrimatiParol();
                        break;
                    case 3:
                        loginUspishniy = false;
                        System.out.println("Ви успішно разлогінились");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Вводіть тільки цифри");
            }
        }while(loginUspishniy);
    }
    public static String otrimatiParol(){
        boolean isValid = false;
        boolean hasSpecialSymbol = false;
        boolean hasThreeNumbers = false;
        boolean hasNoSpaces;
        boolean isLongEnough;
        int count=0;
        String password = "";
        specialniSimvoli = "!\"#$%&'()+,-./:;<=>?@[\\]^_`{|}~".toCharArray();
        for (char i = 33; i<127; i++){
            simvoli[i-33] = i;
        }
        do{
            try {
                password = scanner.nextLine();
            }
            catch(NoSuchElementException e){
                System.out.println("Введена строка пуста. Спробуйте знову");
                continue;
            }
            if (password.length() < 10){
                System.out.println("Недостатня довжина. Як мінімум 10 символів");
                isLongEnough = false;
            }
            else{
                isLongEnough = true;
            }
            if (password.contains(" ")){
                System.out.println("Пароль не має містити пробілів");
                hasNoSpaces = false;
            }
            else{
                hasNoSpaces = true;
            }
            for(int i = 0; i< specialniSimvoli.length; i++){
                if (password.contains(String.valueOf(specialniSimvoli[i]))){
                    hasSpecialSymbol = true;
                    break;
                }
                else {
                    hasSpecialSymbol = false;
                }
            }
            if(!hasSpecialSymbol){
                System.out.println("Пароль має містити хоча б один спеціальний символ");
            }

            for (char ch : password.toCharArray()) {
                if (Character.isDigit(ch)) {
                    count++;
                    if (count >= 3) {
                        hasThreeNumbers = true;
                        break;
                    }
                }
            }
            if(!hasThreeNumbers){
                System.out.println("Пароль має містити як мінімум три цифри");
            }
            if (hasNoSpaces && hasSpecialSymbol && hasThreeNumbers && isLongEnough){
                System.out.println("Пароль користувача встановлено!");
                isValid = true;
            }
        }while(!isValid);
        return password;
    }
    public static String otrimatiImya(){
        boolean isValid = false;
        boolean isLongEnough;
        boolean hasNoSpaces;
        String imya = "";
        scanner.nextLine();
        do{
            try {
                imya = scanner.nextLine();
            }
            catch(NoSuchElementException e){
                System.out.println("Введена строка пуста. Спробуйте знову");
                continue;
            }
            if (imya.length() < 5){
                System.out.println("Недостатня довжина");
                isLongEnough = false;
            }
            else{
                isLongEnough = true;
            }
            if (imya.contains(" ")){
                System.out.println("Не має містити пробілів");
                hasNoSpaces = false;
            }
            else{
                hasNoSpaces = true;
            }
            if (hasNoSpaces && isLongEnough){
                System.out.println("Ім'я користувача встановлено!");
                isValid = true;
            }
        }while(!isValid);
        return imya;
    }
    public static void vividBaziKoristuvachiv(){
        for (int i = 0; i < 15; i++) {
            System.out.print(bazaKoristuvachiv[i][0]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i<15; i++){
            for (int j = 0; j<2; j++){
                bazaKoristuvachiv[i][j] = i+1 + ". пусто ";
            }
        }
        boolean running = true;

        while(running) {
            System.out.println("Введіть число, що б вибрати дію:");
            System.out.println("1. Логін користувача");
            System.out.println("2. Додавання нового користувача");
            System.out.println("3. Видалення користувача");
            System.out.println("4. Виведення всіх користувачів");
            System.out.println("5. Вийти з програми");
            try {
                switch (scanner.nextInt()) {
                    case 1:
                        loginUspishniy = login();
                        if (loginUspishniy) {
                            loggedIn();
                        }
                        break;
                    case 2:
                        dobavitiKoristuvacha();
                        break;
                    case 3:
                        vidalitiKoristuvacha();
                        break;
                    case 4:
                        vividBaziKoristuvachiv();
                        break;
                    case 5:
                        running = false;
                        System.out.println("Завершення програми");
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Користуйтеся тільки цифрами");
            }
        }
    }
}
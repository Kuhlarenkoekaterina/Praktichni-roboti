import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void vivestiPole(char[][] board, int size){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    board[i][j] = ' ';
                } else if (i % 2 == 0) {
                    board[i][j] = '|';
                } else if (j % 2 == 0) {
                    board[i][j] = '_';
                } else {
                    board[i][j] = '#';
                }
            }
        }
        for (int i = 0; i < size+1; i++) {
            board[0][i * 2] = (char) ('0' + i);
            board[i * 2][0] = (char) ('0' + i);
        }
    }
    public static int nalashtuvannya(Scanner sc, int choice, int size){
        do{
            System.out.println("Введіть розмір 3,5,7 чи 9");

            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Не підтримується");
            }
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) {
                break;
            }
            else{
                size = choice;
            }
        }
        while (choice < 3 || choice > 9 || choice%2 == 0);
        return size;
    }

    public static void zberegtiNalashtuvannya (int size){
        System.out.println("Налаштування збережено у папці проекту");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("nalashtuvannia.txt"))) {
            writer.write(size + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено!" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при запису в файл");
        }
    }

    public static int zagruzitiNalashtuvannya (int size){
        try (BufferedReader reader = new BufferedReader(new FileReader("nalashtuvannia.txt"))) {
            size = Integer.parseInt(reader.readLine());
            return size;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено!" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при зчитуванні файлу");
        }
        return 0;
    }

    public static void statistika (int playerTurn){
        System.out.println("Статистику гри збережено у папці проекту");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("statistika.txt"))) {
            String s = "";
            if (playerTurn%2 == 0){
                s += "Перемога Х\n";
            } else {
                s += "Перемога 0\n";
            }
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("Дата: dd.MM.yyyy \n" + "Час: hh:mm:ss");
            s += "Дата та час гри:\n" + now.format(format);
            writer.write(s);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено!" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Виникла помилка при запису в файл");
        }
    }

    public static boolean perevirkaPeremogi(boolean isWin, char[][] board, char player){
        for (int i = 2; i < board.length; i += 2) {
            for (int j = 2; j < board.length - 4; j += 2) {
                if (j + 4 < board.length && board[i][j] == player && board[i][j + 2] == player && board[i][j + 4] == player) {
                    isWin = true;
                }
                if (i + 4 < board.length && board[j][i] == player && board[j + 2][i] == player && board[j + 4][i] == player) {
                    isWin = true;
                }
            }
        }

        for (int i = 2; i < board.length - 4; i += 2) {
            for (int j = 2; j < board.length - 4; j += 2) {
                if (board[i][j] == player && board[i + 2][j + 2] == player && board[i + 4][j + 4] == player) {
                    isWin = true;
                }
                if (board[i][j + 4] == player && board[i + 2][j + 2] == player && board[i + 4][j] == player) {
                    isWin=true;
                }
            }
        }
        return isWin;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean gameActive = true;
        int size = 3;
        int choice;


        while (gameActive) {

            System.out.println("\nЛаскаво просимо в гру TicTacToe!");
            System.out.println("Грати - 1");
            System.out.println("Налаштування - 2");
            System.out.println("Зберегти налаштування - 3");
            System.out.println("Загрузити налаштування з файлу - 4");
            System.out.println("Вихід - 5");

            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Не підтримується");
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nГрати");
                    System.out.println("Повернутися - 0");
                    System.out.println("Розмір - " + size);

                    boolean isGameActing = true;
                    char[][] board = new char[(size+1) * 2 - 1][(size+1) * 2 - 1];
                    char[] playerChar = {'X', 'O'};
                    char[] coordsChar = {'x', 'y'};
                    int[] stepsCoords = {0, 0};
                    char playerTurn = 0;
                    boolean isWin = false;

                    vivestiPole(board, size);

                    while(isGameActing){
                        playerTurn++;
                        for (int row = 0; row < board.length; row++) {
                            for (int cell = 0; cell < board[row].length; cell++) {

                                System.out.print(board[row][cell] + "  ");

                            }
                            System.out.println();
                        }

                        do{
                            for (int i = 0; i < coordsChar.length; i++) {
                                if(!isGameActing){
                                    break;
                                }
                                do{
                                    System.out.println("\nВведіть " + coordsChar[i] + " координати для " + playerChar[playerTurn%2]);
                                    System.out.println("1 - " + size);

                                    while (!sc.hasNextInt()) {
                                        sc.nextLine();
                                        System.out.println("Не підтримується");
                                    }
                                    choice = sc.nextInt();
                                    sc.nextLine();

                                    if (choice == 0) {
                                        isGameActing = false;
                                        break;
                                    }
                                    else{
                                        stepsCoords[i] = choice;
                                    }
                                }
                                while ((stepsCoords[i] < 0 || stepsCoords[i] > size));
                            }
                        }
                        while (board[stepsCoords[1]*2][stepsCoords[0]*2] != ' ');


                        if (!isGameActing) {
                            System.out.println("Гра завершена");
                            break;
                        }

                        board[stepsCoords[1]*2][stepsCoords[0]*2] = playerChar[playerTurn%2];
                        char player = playerChar[playerTurn%2];

                        if (perevirkaPeremogi(isWin, board, player)){
                            for (int row = 0; row < board.length; row++) {
                                for (int cell = 0; cell < board[row].length; cell++) {

                                    System.out.print(board[row][cell] + "  ");
                                }
                                System.out.println();
                            }
                            System.out.println("Гра завершена, є переможець!");
                            statistika(playerTurn);
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.println("\nНалаштування:");
                    System.out.println("Повернутися - 0");

                    size = nalashtuvannya(sc, choice, size);
                    break;
                case 3:
                    zberegtiNalashtuvannya(size);
                    break;
                case 4:
                    size = zagruzitiNalashtuvannya(size);
                    System.out.println("Налаштування загружено");
                    break;
                case 5:
                    System.out.println("\nВихід");
                    gameActive = false;
            }

        }
    }
}

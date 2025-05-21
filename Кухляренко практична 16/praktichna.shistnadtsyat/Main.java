package praktichna.shistnadtsyat;

import java.util.Scanner;

import static praktichna.shistnadtsyat.nalashtuvannya.*;
import static praktichna.shistnadtsyat.peremogaStatistika.*;

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

                    size = nalashtuvannia(sc, choice, size);
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
package praktichna.shistnadtsyat;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class peremogaStatistika {
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
}

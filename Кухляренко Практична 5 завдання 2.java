import java.util.Scanner;
import java.lang.Math; //Імпортую бібліотеку Math та Scanner

public class Main {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Double fnc;
        System.out.println("Введіть значення a:");
        Double a = scnr.nextDouble();
        System.out.println("Введіть значення b:");
        Double b = scnr.nextDouble();
        System.out.println("Введіть значення x:"); //Запрошую значення а, b та x
        Double x = scnr.nextDouble();

        if (x>=0 && x<7){
            fnc = Math.sin(x);
            System.out.println("f(x)=sin x=" + fnc); //Перший випадок, де х більше або дорівнює 0 та менше 7
        }
        else if (x == 7){
            fnc = Math.abs(3 * Math.pow(Math.E, (a*x+1) - 1));
            System.out.println("f(x)=3e^(ax+1)-1=" + fnc); //Другий випадок, де х дорівнює 7
        }
        else if(x>7 && x<11){
            fnc=Math.pow((b*x-a), -1);
            System.out.println("f(x)=(b*x-a)^-1=" + fnc); //Третій випадок, де x більше 7 та менше 11
        }
    }
}
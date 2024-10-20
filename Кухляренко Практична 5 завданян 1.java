import java.lang.Math;
import java.util.Scanner; //Імпортуємо бібліотеку Math та Scanner

public class Main {
    public static final double a = 0.1;
    public static final double b = 88;
    public static final double c = 2*Math.pow(10, -7);
    public static final double x = Math.pow(a, 2) * Math.pow(Math.E, Math.pow(a/b, 2) * (-1)); //Розраховуємо значення у

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Значення a: " + a);
        System.out.println("Значення b: " + b);
        System.out.println("Значення c: " + c);

        System.out.println("Введіть значення k"); //Запрошуємо значення для к, тому що к є у формулі для y, але у умові к нема
        Double k = scnr.nextDouble();

        double y = Math.atan(Math.sqrt(Math.pow( 4*k / (Math.pow(a,2) * c), -1)));

        System.out.println("Формула для x: x = a^2*e^(-(a/b)^2)");
        System.out.println("Значення x:" + x); //Розраховуємо та виводимо значення х

        System.out.println("Формула y: y = arctg(sqrt(4k/((a^2*c)^1)))");
        System.out.println("Значення y:" + y); //Розраховуємо та виводимо значення у

    }
}
import java.lang.Math;

public class task4 {
    public static void main(String[] args) {
        int size = 91;
        double[] sinVal = new double[size];
        for (int i=0; i<size; i++){
            sinVal[i] = Math.sin(Math.toRadians(i));
            System.out.print(sinVal[i] + " ");
            if (i%10==0){
                System.out.println();
            }
        }

    }
}

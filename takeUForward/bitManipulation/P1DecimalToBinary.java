package takeUForward.bitManipulation;

import java.util.Scanner;

public class P1DecimalToBinary {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(convertToBinary(n));
    }

    private static String convertToBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while ( n!= 0){
            if (n % 2 == 0) sb.append("0");
            else sb.append("1");
            n/=2;
        }
        return sb.reverse().toString();
    }
}

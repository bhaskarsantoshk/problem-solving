package CSES;

import java.util.Scanner;

public class P1WeirdAlgorithm {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        printOutput(n);
        System.out.println(1);
    }

    private static void printOutput(long n) {
        if ( n == 1) return;
        System.out.print(n+" ");
        if ( n % 2 == 0) printOutput(n/2);
        else printOutput(n*3 + 1);
    }
}

package CSES;

import java.util.Arrays;
import java.util.Scanner;

public class P5Permutations {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        solve(n);
    }

    private static void solve(int n) {
        if ( n == 1 ){
            System.out.println("1");
            return;
        }
        if ( n < 4) {
            System.out.println("NO SOLUTION");
            return;
        }
        if ( n == 4){
            System.out.println("2 4 1 3");
            return;
        }
        int[] arr = new int[n];
        int num = 1;
        // n = 6 | 1 3 5 2 4 6
        // n = 5 | 1 3 5 2 4
        int index = 0;
        int terminator = 0;
        if ( n % 2 == 0){
            terminator = n-1;
        } else {
            terminator = n;
        }

        while ( num <= terminator){
            arr[index++] = num;
            num += 2;
        }

        num = 2;
        while ( index < n) {
            arr[index++] = num;
            num += 2;
        }

        StringBuilder sb = new StringBuilder();
        for ( int x: arr){
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString());
    }
}

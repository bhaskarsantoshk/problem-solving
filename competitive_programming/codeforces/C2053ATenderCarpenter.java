package competitive_programming.codeforces;

import java.util.Scanner;

public class C2053ATenderCarpenter {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while ( t-- > 0){
            int n = in.nextInt();
            int []a = new int[n];
            for ( int i=0; i<n; i++){
                a[i] = in.nextInt();
            }
            boolean hasValidPartition = false;
            for ( int i=0; i<n-1; i++){
               int x = a[i];
               int y = a[i+1];
               if ( ((x+y) > y) && ((y+y)>x) && ((x+x)>y) ){
                   hasValidPartition = true;
                   break;
               }
            }
            System.out.println(hasValidPartition ? "YES" : "NO");
        }
    }
}

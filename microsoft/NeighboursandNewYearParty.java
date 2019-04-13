package microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NeighboursandNewYearParty {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        while(t!=0){
            int n = in.nextInt();
            int a[] = new int[n];
            for(int i=0; i<n;i++){
                a[i]= in.nextInt();
            }
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<n;i++){
                result.add(new ArrayList<Integer>());
            }
            long dp[] = new long[n];
            dp[0]=a[0];
            dp[1]=a[1];
            int index=0;
            result.get(0).add(a[0]);
            result.get(1).add(a[1]);
            long max = Long.MIN_VALUE;
            if(dp[0] > dp[1]){
                max = dp[0];
                index =0;
            }
            else{
                max = dp[1];
                index = 1;
            }
            for(int i=2; i<n;i++){
                if(dp[i-2]+a[i] > a[i]){
                    dp[i]=dp[i-2]+a[i] ;
                    result.get(i).addAll(result.get(i-2));
                    result.get(i).add(a[i]);
                    if(max < dp[i]){
                        max = dp[i];
                        index=i;
                    }
                }
                else{
                    dp[i]= a[i];
                    result.get(i).add(a[i]);
                }
            }
//            for(int x: dp){
//                System.out.println(x);
//            }
            Collections.reverse(result.get(index));
            for(int x: result.get(index)){
                System.out.print(x+"");
            }
            System.out.println();
            t--;
        }
    }
}

/*

1
5
-1 7 8 -5 4
 */


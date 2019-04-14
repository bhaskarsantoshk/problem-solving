package microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NeighboursandNewYearParty {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- != 0) {
            int n = in.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < n; i++) {
                result.add(new ArrayList<Integer>());
            }

            long dp[] = new long[n];

            dp[0] = a[0];
            if(a[0]!=0){
                result.get(0).add(a[0]);
            }

            if(a[1] > a[0]){
                dp[1] = a[1];
                if(a[1]!=0){
                    result.get(1).add(a[1]);
                }
            }
            else{
                dp[1] = dp[0];
            }

            long max = Integer.MIN_VALUE;
            int index = (dp[1] < dp[0]) ? 0: 1;
            for(int i=2;i<n; i++){
                if(dp[i-2] + a[i] < a[i]){
                    dp[i] = a[i];
                    if(a[i]!=0){
                        result.get(i).add(a[i]);
                    }
                }
                else if(dp[i-2]+ a[i] > dp[i-2]){
                    dp[i] = dp[i-2] +a[i];
                    result.get(i).addAll(result.get(i-2));
                    result.get(i).add(a[i]);
                }
                else if(dp[i-2] > dp[i-2]+a[i]){
                    dp[i]=dp[i-2];
                    result.get(i).addAll(result.get(i-2));
                }

                if(max < dp[i]){
                    max = dp[i];
                    index = i;
                }
                else if(max == dp[i]){
                    if(result.get(index).get(result.get(index).size()-1) < result.get(i).get(result.get(i).size()-1)){
                        index = i;
                    }
                }

            }

            Collections.reverse(result.get(index));
            for(int x: result.get(index)){
                if(x!=0) {
                    System.out.print(x + "");
                }
            }
            System.out.println();
        }
    }
}
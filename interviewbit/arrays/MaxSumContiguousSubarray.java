package interviewbit.arrays;

import java.util.ArrayList;

public class MaxSumContiguousSubarray {
    public static void main(String[] args){
        ArrayList<Integer> a= new ArrayList<>();
        a.add(-2);
        a.add(1);
        a.add(-3);
        a.add(4);
        a.add(-1);
        a.add(2);
        a.add(1);
        a.add(-5);
        a.add(4);
       int result= maxSubArray(a);
       System.out.println(result);
    }

    private static int maxSubArray(ArrayList<Integer> a) {
        int localSum = a.get(0);
        int globalSum = a.get(0);

        for ( int i=1; i< a.size(); i++){
           if ( localSum + a.get(i) > 0 ){
               localSum += a.get(i);
           }
           else{
               localSum = 0;
           }
           globalSum= Math.max( localSum, globalSum);
        }
        return globalSum;
    }
}

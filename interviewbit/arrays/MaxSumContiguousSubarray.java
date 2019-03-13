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
        int localMaxSum = a.get(0);
        int globalMaxSum = a.get(0);

        for(int i=1;i<a.size();i++){
            localMaxSum = Math.max(localMaxSum+a.get(i), a.get(i));
            globalMaxSum = Math.max(localMaxSum, globalMaxSum);
        }
        return globalMaxSum;
    }
}

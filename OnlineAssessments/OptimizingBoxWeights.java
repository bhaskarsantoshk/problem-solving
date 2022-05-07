package OnlineAssessments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OptimizingBoxWeights {
    public static List<List<Integer>> optimizeBoxWeights(int[] weights){
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        long sumA = 0, sumB = 0;
        Arrays.sort(weights);
        reverse ( weights );
        long total = getTotalSum (weights);
        long sum = 0;
        int index = 0;
        while ( index < weights.length && sum < total - sum){
            sum += weights[index];
            A.add(weights[index++]);
        }
        while ( index < weights.length){
            B.add(weights[index++]);
        }
        List<List<Integer>> res = new ArrayList<>();
        Collections.sort(A);
        Collections.sort(B);
        res.add(A);
        res.add(B);
        return res;
    }

    private static long getTotalSum(int[] arr) {
        long sum = 0;
        for ( int num: arr){
            sum+= num;
        }
        return sum;
    }

    private static void reverse ( int[] arr){
        int start = 0, end = arr.length-1;
        while ( start < end ){
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static void main(String[] args){
        int a[] = new int[]{3, 7, 5, 6, 2 };
        System.out.println(optimizeBoxWeights(a));
    }
}

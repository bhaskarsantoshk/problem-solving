package interviewbit.arrays;

import java.util.ArrayList;

public class MaximumUnsortedSubarray {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int startIndex = -1;
        int endIndex = -1;
        for ( int i=0; i< A.size()-2; i++){
            if ( A.get(i) > A.get(i+1)){
                startIndex = i;
                break;
            }
        }
        System.out.println(startIndex);
        if ( startIndex == -1 ){
            result.add(-1);
            return result;
        }
        for ( int i= A.size()-1 ; i>0; i--){
            if ( A.get(i) < A.get(i-1)){
                endIndex = i;
                break;
            }
        }
        System.out.println(endIndex);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for ( int i= startIndex; i<=endIndex; i++){
            min = Math.min(A.get(i), min);
            max = Math.max(A.get(i), max);
        }
        System.out.println(min +" "+max);
        for ( int i=0; i<=startIndex; i++){
           if ( min < A.get(i) ){
                result.add(i);
           }
        }
        for ( int i= A.size()-1; i>= endIndex; i-- ){
            if ( A.get(i) < max ){
                result.add(i);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args ){
        int a[] = { 1, 3, 2 , 4 , 5};
        ArrayList<Integer> al = new ArrayList<>();
        for ( int num: a){
            al.add(num);
        }
        MaximumUnsortedSubarray obj = new MaximumUnsortedSubarray();
        System.out.println(obj.subUnsort(al));
    }
}

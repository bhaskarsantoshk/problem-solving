package interviewbit.arrays;

import java.util.ArrayList;

public class MaxNonNegativeSubArray {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        int sum = 0;
        int l = 0, r = 0;
        int L=0, R=0;
        int maxSum = 0;
        for ( int i=0; i< A.size(); i++ ){
            if ( A.get(i) >=  0){
                sum += A.get(i);
                r= i;

                if ( maxSum < sum ){
                    maxSum = sum;
                    R = r;
                    L = l;
                }
                else if ( maxSum == sum ){
                    if ( R-L <  r-l){
                        R = r;
                        L = l;
                    }
                    else if ( R-L == r-l ){
                        if ( A.get(l) < A.get(L)){
                            R= r;
                            L =l;
                        }
                    }
                }
            }
            else{
                l = i+1;
                r = 0;
                sum =0;
            }
        }
        if ( L== R && A.get(L) < 0){
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for ( int i=L; i <= R; i++){
            result.add(A.get(i));
        }
        return result;
    }

    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>();
        int a[] = {1, 2, 5, -7, 2, 3};
        for ( int x: a){
            A.add(x);
        }
        MaxNonNegativeSubArray obj = new MaxNonNegativeSubArray();
        System.out.println(obj.maxset(A));
    }
}

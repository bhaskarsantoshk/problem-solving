package interviewbit.twopointers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumClosest {

    public static void main(String[] args){
        int[] S = {-1, 2, 1, -4};
        ArrayList<Integer> al = new ArrayList<>();
        for(int x:S){
            al.add(x);
        }
        int result = threeSumClosest(al, 1);
        System.out.println(result);
    }
    public static int threeSumClosest(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int result = A.get(0)+A.get(1)+A.get(2);
        if(A.size()==3){
            return result;
        }
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<A.size()-2;i++){
            int low= i+1, high=A.size()-1;
            while(low < high){
                int sum = A.get(low) + A.get(high)+A.get(i);
                if(sum == B){
                    return B;
                }
                else if(sum > B){
                   // diff = Math.min( Math.abs(sum-B), diff );
                    if(Math.abs(sum-B) < diff){
                        diff = Math.abs(sum-B);
                        result = sum;
                    }
                    high--;
                }
                else{
                   // diff = Math.min( Math.abs(sum-B), diff );
                    if(Math.abs(sum-B) < diff){
                        diff = Math.abs(sum-B);
                        result = sum;
                    }
                    low++;
                }


            }

        }

        return result;
    }
}

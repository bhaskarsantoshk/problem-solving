package microsoft;

import java.util.ArrayList;
import java.util.Collections;

public class Sum3 {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int result = A.get(0)+A.get(1)+A.get(2);
        if(result== B) return result;
        int diff = Integer.MAX_VALUE;

        for(int i=0; i<A.size()-2; i++){
            int low = i+1;
            int high= A.size()-1;

            while(low < high){
                int sum = A.get(low)+A.get(high)+A.get(i);

                if(sum == B){
                    return B;
                }
                else if(sum > B){
                    if(Math.abs(sum-B) < diff){
                        diff = Math.abs(sum-B);
                        result = sum;
                    }
                    high--;
                }
                else{
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

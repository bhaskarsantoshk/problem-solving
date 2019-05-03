package company.microsoft;

import java.util.List;

public class Array3Pointers {
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int i=0,j=0,k=0;
        int I=0,J=0,K=0;
        int diff = Integer.MAX_VALUE;
        while(i<A.size() && j<B.size() && k<C.size()){
            int minimum = Math.min(Math.min(A.get(i), B.get(j)), C.get(k));
            int maximum = Math.max(Math.max(A.get(i), B.get(j)), C.get(k));
            if(diff > Math.abs(maximum- minimum)){
                diff = Math.abs(maximum-minimum);
                I=i; J=j; K=k;
            }
            if(diff == 0){
                break;
            }
            if(A.get(i)== minimum){
                i++;
            }
            else if(B.get(j)== minimum){
                j++;
            }
            else{
                k++;
            }
        }
        return diff;
    }
}

package microsoft;

import java.util.List;

public class MaxProductSubarray {
    public int maxProduct(final List<Integer> A) {
        long[] max= new long[A.size()];
        long[] min = new long[A.size()];
        max[0]= A.get(0);
        min[0] = A.get(0);
        long maxProduct = A.get(0);

        for(int i=1;i<A.size(); i++){
            if(A.get(i) > 0){
                max[i] = Math.max(A.get(i), max[i-1]*A.get(i));
                min[i]= Math.min(A.get(i), min[i-1]*A.get(i));
            }
            else{
                max[i] = Math.max(A.get(i), min[i-1]*A.get(i));
                min[i]= Math.min(A.get(i), max[i-1]*A.get(i));
            }
            maxProduct = Math.max(maxProduct, max[i]);
        }

        return (int) maxProduct;
    }
}

package company.amazon.interviewbit;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    public String largestNumber(final List<Integer> A) {
        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String XY = String.valueOf(o1) + String.valueOf(o2);
                String YX = String.valueOf(o2) + String.valueOf(o1);
                return YX.compareTo(XY);
            }
        });

        StringBuilder res = new StringBuilder();
        for ( int num: A){
            if ( num == 0 && res.length() != 0 ){
                continue;
            }
            res.append(String.valueOf(num));
        }
        return res.toString();
    }
}

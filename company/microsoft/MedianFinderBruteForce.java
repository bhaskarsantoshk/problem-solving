package company.microsoft;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MedianFinderBruteForce {
    List<Integer> list;
    public MedianFinderBruteForce() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        int size = list.size();
        Collections.sort(list);
        if ( size % 2 == 0){
            int mid = size/2;
            int mid2 = size/2-1;
            // size = 4 -> 0 1 2 3

            return (double) (list.get(mid) + list.get(mid2))/2.0;
        }else {
            return list.get(size/2);
        }
    }
}

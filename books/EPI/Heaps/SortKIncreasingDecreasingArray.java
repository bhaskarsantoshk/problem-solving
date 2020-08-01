package books.EPI.Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortKIncreasingDecreasingArray {

    private enum SubArrayType{ INCREASING, DECREASING};

    public static List<Integer> sortKIncreasingDecreasingArray (List<Integer> a){
        List<List<Integer>> sortedArrays = new ArrayList<>();
        SubArrayType subArrayType = SubArrayType.INCREASING;
        int startIndex = 0;
        for ( int i=1; i<=a.size(); i++){
            if (i == a.size() ||
                    (a.get(i-1) < a.get(i) && subArrayType == SubArrayType.DECREASING) ||
                    (a.get(i-1) >= a.get(i) && subArrayType == SubArrayType.INCREASING)){
                List<Integer> subList = a.subList(startIndex, i);
                if ( subArrayType == SubArrayType.DECREASING ){
                    Collections.reverse(subList);
                }
                sortedArrays.add(subList);
                startIndex = i;
                subArrayType = (subArrayType == SubArrayType.INCREASING ? SubArrayType.DECREASING : SubArrayType.INCREASING);
            }
        }
        return MergeSortedArrays.mergeSortedArrays(sortedArrays);
    }
}


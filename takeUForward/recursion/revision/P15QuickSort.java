package takeUForward.recursion.revision;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

public class P15QuickSort {
    public static List<Integer> quickSort(List<Integer> arr){
        List<Integer> list = new ArrayList<>(arr);

       quickSort(list, 0, arr.size()-1);
       return list;
    }

    private static void quickSort(List<Integer> arr, int low, int high) {
        if ( low < high ){
            int partitionIndex = findPartitionIndex(arr, low, high);
            quickSort(arr, low, partitionIndex-1);
            quickSort(arr, partitionIndex+1, high);
        }
    }

    private static int findPartitionIndex(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i=low, j=high;
        while ( i < j){
            while ( arr.get(i) <= pivot && i <= high-1) i++; // not to cross boundary whem we do i++
            while ( arr.get(j) > pivot && j >= low+1) j--; // not to cross boundary whem we do j--
            if ( i < j) swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }
}

package takeuForward.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSums {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> res = new ArrayList<>();
        subsetSums(arr, 0, n, 0, res);
        Collections.sort(res);
        return res;
    }

    private void subsetSums(ArrayList<Integer> arr, int index, int n, int sum, List<Integer> res) {
        if ( index == n){
            res.add(sum);
            return;
        }
        subsetSums(arr, index+1, n, sum+arr.get(index), res);
        subsetSums(arr, index+1, n, sum, res);
    }
}

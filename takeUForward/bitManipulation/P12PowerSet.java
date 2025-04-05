package takeUForward.bitManipulation;

import java.util.ArrayList;

public class P12PowerSet {
    public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for ( int num=1; num<(1<<arr.size()); num++){
            ArrayList<Integer> list = new ArrayList<>();
            for ( int i=0; i<arr.size(); i++){
                if ((num &(1<<i)) != 0) list.add(arr.get(i));
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}

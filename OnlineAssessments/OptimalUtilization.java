package OnlineAssessments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OptimalUtilization {
    private List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
        Collections.sort(a, (o1,o2)->o1[1]-o2[1]);
        Collections.sort(b, (o1,o2)->o1[1]-o2[1]);
        int i =0, j= b.size()-1;
        int max = Integer.MIN_VALUE;
        List<int[]> result = new ArrayList<>();
        while ( i < a.size() && j >= 0){
            int sum = a.get(i)[1]+ b.get(j)[1];
            if ( sum > target){
                j--;
            } else {
                if (sum <= max){
                    if ( sum < max){
                        max = sum;
                        result.clear();
                    }
                    result.add(new int[]{a.get(i)[1], b.get(j)[1]});
                    int index = j-1;
                    while ( index >=0 && b.get(index) == b.get(index+1)){
                        result.add(new int[] {a.get(i)[1], b.get(index--)[1]});
                    }
                }
            }
            i++;
        }
        return result;
    }
}

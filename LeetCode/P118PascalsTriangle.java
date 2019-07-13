package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class P118PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if ( numRows <= 0 ){
            return result;
        }
        result.add(new ArrayList<>());
        result.get(0).add(1);
        int index =1;
        while ( index < numRows ){
            result.add(new ArrayList<>());
            result.get(index).add(1);
            for (int i=0; i< result.get(index-1).size()-1 ; i++){
                int sum = result.get(index-1).get(i) + result.get(index-1).get(i+1);
                result.get(index).add(sum);
            }
            result.get(index).add(1);
            index++;
        }
        return result;
    }
}

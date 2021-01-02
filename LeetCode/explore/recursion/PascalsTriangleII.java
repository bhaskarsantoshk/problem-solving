package Leetcode.explore.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
       if (rowIndex == 0) return Arrays.asList(1);
       List<Integer> previousList = getRow(rowIndex-1);
       List<Integer> thisList = new ArrayList<>();
       thisList.add(1);
       for ( int i=1; i<=previousList.size()-1; i++){
         thisList.add(previousList.get(i)+ previousList.get(i-1));
       }
       thisList.add(1);
       return thisList;
    }
}

/*

1. Terminating condition
2. Use head recursion
3. Calculate the current list based on previous list.

URL: https://leetcode.com/explore/featured/card/recursion-i/251/scenario-i-recurrence-relation/3234/

*/
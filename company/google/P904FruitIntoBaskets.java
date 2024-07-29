package company.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P904FruitIntoBaskets {

    /*
    Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].

     */
    public int totalFruit(int[] fruits) {
        // longest sub-array with at most two distinct integers
        int left = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count =0;
        for ( int right =0; right <fruits.length; right++){
            if ( map.containsKey(fruits[right])){
                map.put(fruits[right], map.get(fruits[right])+1);
            } else {
                count++;
                map.put(fruits[right], 1);
            }
            while ( count > 2 ) {
                if ( map.containsKey(fruits[left])){
                    map.put(fruits[left], map.get(fruits[left])-1);
                    if ( map.get(fruits[left]) == 0){
                        map.remove(fruits[left]);
                        count--;
                    }
                }
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}

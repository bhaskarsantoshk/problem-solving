package company.apple;

import java.util.HashMap;
import java.util.Map;

public class P5RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] romanNums = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] nums = {1,5,10, 50, 100, 500, 1000};
        for ( int i=0; i<nums.length; i++){
            map.put(romanNums[i], nums[i]);
        }
        int ans = 0;
        for ( int i=0; i<s.length-1; i++) {
            char first = s.charAt(i);
            char second = s.charAt(i + 1);
            if (map.get(first) < map.get(second)) ans -= map.get(first);
            else ans += map.get(first);
        }
        char last = s.charAt(s.length()-1);
        ans += map.get(last);
        return ans;
    }
}

package express_prep.amzn.top_voted;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        map.put('A', 0);
        char prev = 'A';
        int res = 0;
        for ( char c: s.toCharArray()){
            if ( map.get(c) > map.get(prev)){
                res -= 2 * map.get(prev);
            }
            res += map.get(c);
            prev = c;
        }
        return res;
    }
}

package company.google.others;

import java.util.HashMap;
import java.util.Map;

public class P246StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        // 0 1 2 3 4 5 6 7 8 9
        // 0 - 0, 1 - 1, 6-9, 8-8, 9-6
        Map<Character, Character> map = new HashMap();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        int left = 0, right = num.length()-1;
        while ( left <= right){
            if ( !map.containsKey(num.charAt(left))) return false;
            if ( map.get(num.charAt(left)) != num.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

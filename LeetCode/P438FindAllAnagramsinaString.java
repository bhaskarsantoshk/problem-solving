package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P438FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new ArrayList<>();
        if( t.length() > s.length() ){
            return result;
        }
        Map<Character, Integer> map = new HashMap<>();
        for( char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int counter = map.size();
        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;
        return result;
    }
}

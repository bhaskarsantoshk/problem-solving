package company.amazon.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if ( strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for ( String s: strs){
            char[] ca = new char[26];
            for ( char c: s.toCharArray()) ca[c-'a']++;
            String key = String.valueOf(ca);
            if ( !map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}

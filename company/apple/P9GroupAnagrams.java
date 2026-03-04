package company.apple;

import java.util.*;

public class P9GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for ( String word: strs){
            char[] counts = new char[26];
            for ( char c: word.toCharArray()) counts[c-'a']++;
            String key = String.valueOf(counts);
            if ( map.containsKey(key)) map.get(key).add(word);
            else {
                map.put(key, new ArrayList<>());
                map.get(key).add(word);
            }
        }
        return new ArrayList<>(map.values());
    }
}

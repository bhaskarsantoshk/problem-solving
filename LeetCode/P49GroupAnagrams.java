package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String str: strs ){
            char arr[] = new char[26];
            for(int i=0; i<str.length(); i++){
                arr[str.charAt(i)-'a']++;
            }
            String s = new String(arr);
            if( map.containsKey(s) ){
                map.get(s).add(str);
            }
            else{
                ArrayList<String> al = new ArrayList<>();
                al.add(str);
                map.put(s, al);
            }
        }
        result.addAll(map.values());
        return result;
    }
}

package company.microsoft;


import java.util.HashMap;
import java.util.Map;

public class P953VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> mapping = new HashMap<>();
        int index=0;
        for ( char c: order.toCharArray()) mapping.put(c, index++);
        for ( int i=1; i<words.length; i++){
            if ( !inOrder(words[i-1], words[i], mapping)){
                return false;
            }
        }
        return true;
    }

    private boolean inOrder(String first, String second, Map<Character, Integer> mapping) {
        int m = first.length(), n =second.length();
        for ( int i=0; i<Math.min(m,n); i++){
            if (first.charAt(i) == second.charAt(i)) continue;
            return mapping.get(second.charAt(i)) > mapping.get(first.charAt(i));
        }
        return n >= n;
    }
}

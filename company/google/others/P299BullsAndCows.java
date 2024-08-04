package company.google.others;

import java.util.HashMap;
import java.util.Map;

public class P299BullsAndCows {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for ( char c: secret.toCharArray()) frequencyMap.put(c, frequencyMap.getOrDefault(c,0)+1);
        int bulls=0, cows=0;
        for ( int i=0; i<guess.length(); i++){
            char c = guess.charAt(i);
            if (frequencyMap.containsKey(c)) {
                if ( c == secret.charAt(i)) {
                    bulls++;
                    if ( frequencyMap.get(c) <= 0) cows--;
                } else {
                    if ( frequencyMap.get(c) > 0) cows++;
                }
                frequencyMap.put(c, frequencyMap.get(c)-1);
            }
        }
        return Integer.toString(bulls)+"A"+Integer.toString(cows)+"B";
    }

    public String getHintOptimized(String secret, String guess) {
        int [] map = new int[10];
        int bulls=0, cows=0;
        for ( int i=0; i<guess.length(); i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if ( s==g) bulls++;
            else {
                if ( map[s-'0'] < 0) cows++;
                if ( map[g-'0'] > 0 ) cows++;
                map[s-'0']++;
                map[g-'0']--;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cows).append("A").append(bulls).append("B");
        return sb.toString();
    }
}

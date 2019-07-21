package LeetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P127WordLadder {
    public int ladderLength(String start, String end, List<String> dictV) {
        Set<String> dictionary = new HashSet<>(dictV);
        Set<String> reached = new HashSet<String>();
        //dictionary.add(end);
        reached.add(start);
        int distance = 1;
        while ( !reached.contains(end)){
            Set<String> toAdd = new HashSet<String>();
            for ( String each: reached){
                for ( int i=0; i< each.length(); i++){
                    char ch[] = each.toCharArray();
                    for ( char c='a' ; c<= 'z'; c++){
                        ch[i] = c;
                        String word = new String(ch);
                        if ( dictionary.contains(word)){
                            toAdd.add(word);
                            dictionary.remove(word);
                        }
                    }
                }
            }
            distance++;
            if ( toAdd.size()== 0){
                return 0;
            }

            reached = toAdd;
        }

        return distance;
    }
}

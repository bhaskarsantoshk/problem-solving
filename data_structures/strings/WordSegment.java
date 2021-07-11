package data_structures.strings;

import java.util.HashSet;
import java.util.Set;

public class WordSegment {
    public static void main(String[] args){
        Set< String > dictionary = new HashSet< String >();
        String s = new String();
        s = "hellonow";

        dictionary.add("hello");
        dictionary.add("hell");
        dictionary.add("on");
        dictionary.add("now");
        if ( canSegmentsBePartOfDictionary(s, dictionary)) {
            System.out.println("String Can be Segmented");
        } else {
            System.out.println("String Can NOT be Segmented");
        }
    }

    private static boolean canSegmentsBePartOfDictionary(String s, Set<String> dictionary) {
        if ( s == null || s.length() == 0 || dictionary.contains(s)){
            return true;
        }
        for ( int i=1; i<=s.length() ; i++){
            String first = s.substring(0,i);
            if ( dictionary.contains(first)){
                String second = s.substring(i);
                if ( second == null || second.length() == 0 ||
                        dictionary.contains(second) || canSegmentsBePartOfDictionary(second, dictionary)){
                    return true;
                }
            }
        }
        return false;
    }
}

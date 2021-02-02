package bytebybyte;

public class Anagrams {
    public boolean areAnagrams (String s1, String s2){
        if ( s1.length() != s2.length() ) return false;
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int [] letters = new int[1<<8]; // represents one byte - optional though :P
        for (char c: s1.toCharArray()){
            letters[c]++; // chars are just numbers (integers: 0-256 (unsigned)).
        }
        for (char c: s2.toCharArray()){
            letters[c]--;
        }
        for ( int num: letters){
            if ( num != 0) return false;
        }
        return true;
    }
}

// ask for character set: alphabets, alphanumeric, ASCII or 2 byte unicode - handling internationalization
// Uppercase vs lowercase letters


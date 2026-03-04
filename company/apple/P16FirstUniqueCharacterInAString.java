package company.apple;

public class P16FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int []count = new int[26];
        for ( char c: s.toCharArray()) count[c-'a']++;
        for ( int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if ( count[c-'a'] == 1) return i;
        }
        return -1;
    }
}

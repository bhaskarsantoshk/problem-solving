package company.microsoft;

public class P767ReorganizeString {
    public String reorganizeString(String s) {
        int [] hash = new int[26];
        for ( char c: s.toCharArray()) hash[c-'a']++;
        int max=0;
        char maxRepeatedChar = '#';
        for ( int i=0; i<26; i++){
            if ( hash[i] > max) {
                max = hash[i];
                maxRepeatedChar = (char)('a'+i);
            }
        }
        if ( max > (s.length()+1)/2) return "";
        char[] res = new char[s.length()];
        int index = 0;
        while ( hash[maxRepeatedChar-'a']-- > 0){
            res[index]= maxRepeatedChar;
            index+= 2;
        }
        for ( int i=0; i<26; i++){
            while(hash[i]-- > 0){
                if ( index >= s.length()) index=1;
                res[index] = (char)('a'+i);
                index+= 2;
            }
        }
        return String.valueOf(res);
    }
}

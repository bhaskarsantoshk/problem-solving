package company.amazon.leetcode;

public class P767ReorganizeString {
    public static String reorganizeString(String s) {
        if ( s == null || s.length() == 0) return "";
        int hash[] = new int[26];
        for ( char c: s.toCharArray()){
            hash[c-'a']++;
        }
        char maxRepeatedLetter = ' ';
        int max = 0;
        for ( int i=0; i< hash.length; i++){
            if ( hash[i] > max){
                max = hash[i];
                maxRepeatedLetter = (char) ('a'+i);
            }
        }
        if ( max > (s.length()+1) / 2){
            return "";
        }
        int index = 0;
        char res[] = new char[s.length()];
        while ( hash[maxRepeatedLetter-'a'] > 0){
            res[index]= maxRepeatedLetter;
            index+=2;
            hash[maxRepeatedLetter-'a']--;
        }
        for (int i=0; i<hash.length; i++){
            while ( hash[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                res[index] = (char)('a'+i);
                index+= 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args){
        String res = reorganizeString("aab");
        System.out.println(res);
    }
}

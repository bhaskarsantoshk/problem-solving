package takeUForward.basic.strings;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] str) {
        String prefix = str[0];
        for ( String s: str){
            while ( s.indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }
}

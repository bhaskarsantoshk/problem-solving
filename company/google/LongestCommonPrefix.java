package LeetCode.company.google;

class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for ( String str : strs){
            while ( str.indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }
}

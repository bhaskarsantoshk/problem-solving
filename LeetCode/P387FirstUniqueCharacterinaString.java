package LeetCode;

public class P387FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        int a[] = new int[26];
        for(int i=0; i<s.length(); i++){
            a[s.charAt(i)-'a']++;
        }
        for(int i=0; i<s.length(); i++){
            if(a[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}

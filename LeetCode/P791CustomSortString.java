package LeetCode;

public class P791CustomSortString {
    public String customSortString(String S, String T) {
        int bucket[] = new int[26];
        for (int i=0; i< T.length(); i++){
            bucket[T.charAt(i)-'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0; i< S.length(); i++){
            for(int j=0; j< bucket[S.charAt(i)-'a']; j++){
                sb.append(S.charAt(i));
            }
            bucket[S.charAt(i)-'a']= 0;
        }
        for(int i=0; i< 26; i++){
            for(int j=0; j< bucket[i]; j++){
                sb.append((char)(i+'a'));
            }
        }
        return sb.toString();
    }
}

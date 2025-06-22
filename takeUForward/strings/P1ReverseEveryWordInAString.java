package takeUForward.strings;

import java.util.ArrayList;
import java.util.List;

public class P1ReverseEveryWordInAString {
    public String reverseWords(String s) {
        List<String> res = new ArrayList<>();
        int start = 0, end = 0;
        int i=0, n = s.length();
        while ( i < n){
            while ( i < n && s.charAt(i) == ' ') i++;
            if ( i >= n) break;
            start = i;
            while ( i < n && s.charAt(i) != ' ') i++;
            end = i;
            res.add(s.substring(start, end));
        }
        StringBuilder sb = new StringBuilder();
        for ( i=res.size()-1; i>=0; i--){
            sb.append(res.get(i));
            if ( i != 0) sb.append(" ");
        }
        return sb.toString();
    }

    public String reverseWordsOptimal(String s) {
        int n = s.length();
        char[] str = new char[n];
        for ( int i=0; i<n; i++) str[i] = s.charAt(i);
        reverse(str, 0, n-1);
        int i=0, j=0, start =0, end = 0;
        while ( j < n){
            while ( j < n && str[j] == ' ')j++;
            start = i;
            while ( j < n && str[j] != ' '){
                str[i] = str[j];
                i++;
                j++;
            }
            end = j-1;
            reverse(str, start, end);
            str[i] = ' ';
            i++;
        }
        StringBuffer sb = new StringBuffer();
        for ( int index=0; index< end; index++){
            sb.append(str[index]);
        }
        return sb.toString();
    }

    private void reverse(char[] s, int start, int end) {
        while (start <= end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}

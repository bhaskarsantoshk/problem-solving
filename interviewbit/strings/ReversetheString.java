package interviewbit.strings;

public class ReversetheString {
    public String reverseWords(String a) {
        char s[] = a.toCharArray();
        reverse(s, 0, a.length()-1);
        reverseWords(s, a.length());
        return cleanUpSpaces(s, s.length);
    }

    private void reverseWords(char[] s, int n) {
        int i=0;
        int j=0;
        while ( i < n){
            while ( i < j || i < n && s[i] == ' '){
                i++;
            }
            while ( j < i || j < n && s[j] != ' '){
                j++;
            }
            reverse(s, i, j-1);
        }
    }

    private String cleanUpSpaces(char[] s, int n) {
        int index = 0;
        int i=0;
        while ( i < n){
            while ( i < n && s[i] == ' '){
                i++;
            }
            while ( i < n && s[i] != ' '){
                s[index++] = s[i++];
            }
            while ( i < n && s[i] == ' '){
                i++;
            }
            if ( i < n){
                s[index++] = ' ';
            }
        }
        return new String(s).substring(0, i);
    }

    private void reverse(char[] s, int start, int end) {
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }

    }
}

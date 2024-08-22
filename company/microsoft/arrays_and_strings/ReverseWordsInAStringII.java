package company.microsoft.arrays_and_strings;

public class ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        reverseWordByWord(s, s.length);
    }

    private void reverseWordByWord(char[] s, int length) {
        int i=0, j=0;
        while ( i < length) {
            while ( i < j || (i < length && s[i] == ' ' ) ) i++;
            while ( j < i || (j < length && s[j] != ' ')) j++;
            reverse(s, i, j-1);
        }
    }

    private void reverse(char[] s, int start, int end) {
        while ( start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}

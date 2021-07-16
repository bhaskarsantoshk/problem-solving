package LeetCode.explore.top_interview_questions.easy;

public class ReverseString {
    public void reverseString(char[] s) {
        helper(s,0,s.length-1);
    }

    private void helper(char[] s, int start, int end) {
        if ( start < end ){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            helper(s, start+1, end-1);
        }
    }
}

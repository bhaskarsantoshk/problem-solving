package LeetCode.explore.recursion;

import java.util.Arrays;

public class   ReverseString {
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

    public static void main(String[] args){
        String str = "algorithm";
        char s[] = str.toCharArray();
        ReverseString obj = new ReverseString();
        System.out.println(Arrays.toString(s));
        obj.reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}

/*

call a helper function with o, len as indices. use tail recursion concept after swapping start and end, 
recusrively call the function with start+1, end-1. terminating condition is when start == end.

Output:
[a, l, g, o, r, i, t, h, m]
[m, h, t, i, r, o, g, l, a]


https://LeetCode.com/explore/featured/card/recursion-i/250/principle-of-recursion/1440/
*/
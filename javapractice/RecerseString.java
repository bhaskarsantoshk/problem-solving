package javapractice;

public class RecerseString {
    public String reverseString(String s){
        char[] str = s.toCharArray();
        int start = 0, end = s.length()-1;
        while (start!= end){
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        String reverse = String.copyValueOf(str);
        return reverse;
    }
}

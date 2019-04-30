package LeetCode;

public class P125ValidPalindrome {
    public boolean isPalindrome(String s) {
        s= s.toLowerCase();
        int start = 0;
        int end = s.length()-1;
        while( start <= end ){
            char a= s.charAt(start);
            char b = s.charAt(end);
            if(!isAlphaNumeric(a)){
                start++;
            }
            else if(!isAlphaNumeric(b)){
                end--;
            }
            else{
                if(a!=b){
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    public boolean isAlphaNumeric(char c){
        return ((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9'));
    }
}

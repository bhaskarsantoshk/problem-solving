package LeetCode;

public class P1221SplitAStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        int balanced = 0;
        int res = 0;
        for ( int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if ( c == 'L'){
                balanced+=1;
            }
            else{
                balanced-=1;
            }
            if (balanced == 0){
                res++;
            }
        }
        return res;
    }
}

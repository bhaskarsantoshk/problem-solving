package LeetCode;

public class P1021RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int opened = 0;
        for(char c: s.toCharArray()){
            if( c== '(' && opened++ > 0 ){
                sb.append(c);
            }
            else if(c == ')' && opened-- > 1 ){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

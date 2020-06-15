package LeetCode;

public class P1323Maximum69Number {
    public int maximum69Number (int num) {
        String s = String.valueOf(num);
        char c[] = s.toCharArray();

        boolean flag = false;
        for ( int i=0; i<c.length; i++){
            if (c[i]=='6'){
                c[i] ='9';
                break;
            }
        }
        
        return Integer.parseInt(String.valueOf(c));
    }
}

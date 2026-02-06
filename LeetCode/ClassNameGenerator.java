package LeetCode;

public class ClassNameGenerator {
    static String getClassName(String s){
        StringBuilder sb = new StringBuilder();
        for ( int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if ( (i == 0 || !isAlphabet(s.charAt(i-1))) && (isAlphabet(c)) ){
                if ( c >= 'a' && c <= 'z'){
                    c = (char)(c & 0x5f) ;
                }

                sb.append(c);
            }
            else if ( isSpecialCharacter(c)){
                continue;
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static boolean isSpecialCharacter(char c) {
        return !isAlphabet(c) && !(c>='0' && c<='9') ;
    }

    private static boolean isAlphabet(char c) {
        return ((c>='a' && c<='z') || (c>='A' && c<='Z'));
    }

    public static void main(String[] args){
        String s ="Alien Dictionary";
        // Expected Output : P392IsSubsequence
        System.out.println("P"+getClassName(s));
    }
}

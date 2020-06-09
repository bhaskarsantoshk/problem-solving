package LeetCode;

public class ClassNameGenerator {
    static String getClassName(String s){
        StringBuilder sb = new StringBuilder("P");
        for ( int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if ( (i == 0 || !isAlpahabet(s.charAt(i-1))) && (isAlpahabet(c)) ){
                if ( c >= 'a' && c <= 'z'){
                    c = (char)(c & 0x5f) ;
                }

                sb.append(c);
            }
            else if ( isSpecialCharacter(c)){
                // do nothing
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static boolean isSpecialCharacter(char c) {
        return !isAlpahabet(c) && !(c>='1' && c<='9') ;
    }

    private static boolean isAlpahabet(char c) {
        return ((c>='a' && c<='z') || (c>='A' && c<='Z'));
    }

    public static void main(String[] args){
        String s = "392. Is Subsequence\n";
        // Expected Output : P1313DecompressRunLengthEncodedList
        System.out.println(getClassName(s));
    }
}

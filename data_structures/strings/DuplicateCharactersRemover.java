package data_structures.strings;

public class DuplicateCharactersRemover {
    static void removeDuplicates(char[] str){
        int[] ascii = new int[256];
        int index = 0;
        for ( int i=0; i<str.length; i++){
            char c = str[i];
            if (ascii[c] == 0){
                str[index++] = c;
                ascii[c] = 1;
            }
        }
        if ( index < str.length ) {
            str[index] = '\0';
        }
    }

    public static void main(String[] args){
        String s = "abcabc";
        char[] str = s.toCharArray();
        printStr(str);
        removeDuplicates(str);
        printStr(str);
    }

    private static void printStr(char[] str) {
        for ( char c: str){
            if ( c != '\0'){
                System.out.print(c);
            }
            else{
                break;
            }
        }
        System.out.println();
    }
}

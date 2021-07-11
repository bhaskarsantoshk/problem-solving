package data_structures.strings;

public class WhiteSpaceRemover {
    public static void removeWhiteSpaces (char[] str){
        int index = 0;
        for ( int i=0; i<str.length; i++){
            if ( str[i] != ' ' && str[i] != '\t'){
                str[index++] = str[i];
            }
        }
        if ( index < str.length){
            str[index]='\0';
        }
    }

    public static void main(String[] args){
        String s = " All Greek          to      me";
        char[] str = s.toCharArray();
        printStr(str);
        removeWhiteSpaces(str);
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

package Recursion;

import static Recursion.DataFormatter.print;

public class ReversString {
    public static String reverseString ( String s){
        if ( s.isEmpty() ) return s;
        return reverseString(s.substring(1))+s.charAt(0);
    }
    public static void main(String [] args){
        print(reverseString("Batman"));
    }
}

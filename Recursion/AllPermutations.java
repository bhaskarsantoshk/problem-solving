package Recursion;

import static Recursion.DataFormatter.print;
import static Recursion.DataFormatter.swap;

public class AllPermutations {
    public static void printPermutations(char[] a, int index){
        if ( index == a.length-1){
            print(a);
        }
        for ( int i = index; i<a.length; i++){
            swap(a, i, index);
            printPermutations(a,index+1);
            swap(a,index,i);
        }
    }

    public static void main(String[] args){
        char[] a= {'a','b','c'};
        printPermutations(a,0);
    }
}

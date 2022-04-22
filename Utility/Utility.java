package Utility;

import java.util.ArrayList;

public class Utility {
    public static void print (String s){
        System.out.println(s);
    }
    public static void print (int[] a){
        for ( int num: a){
            System.out.print(num+" ");
        }
        System.out.println();
    }
    public static void print (ArrayList<Integer> al){
        if ( al == null ){
            System.out.println("Null");
            return;
        }
        for ( int num: al){
            System.out.print(num+" ");
        }
        System.out.println();
    }
}

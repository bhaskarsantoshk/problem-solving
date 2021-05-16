package Recursion;

public class Print {
    public static void print(int x){
        System.out.println(x);
    }
    public static void print(String s){
        System.out.println(s);
    }
    public static void print(int[] a){
        for ( int num: a){
            System.out.print(num+" ");
        }
    }
    public static void print(char[] a){
        for(char c: a){
            System.out.println(c+" ");
        }
    }
}


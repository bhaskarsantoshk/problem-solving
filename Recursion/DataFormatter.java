package Recursion;

public class DataFormatter {
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
            System.out.print(c+" ");
        }
        System.out.println();
    }
    public static void swap(char[] a, int i, int j){
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}


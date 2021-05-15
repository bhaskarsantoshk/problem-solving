package Recursion;

public class TwentyIntegers {
    static int n = 0;

    public static void indirectRecursiveFunction1 (){
        if ( n <= 20){
            System.out.println(n+" ");
            n++;
            indirectRecursiveFunction2();
        }
    }

    private static void indirectRecursiveFunction2() {
        if ( n <= 20){
            System.out.println(n+ " ");
            n++;
            indirectRecursiveFunction1();
        }
    }

    public static void main(String[] args){
        indirectRecursiveFunction1();
    }
}
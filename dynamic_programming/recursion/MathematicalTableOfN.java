package dynamic_programming.recursion;

public class MathematicalTableOfN {
    static void printTable(int n){
        for(int i=1;i<=10;i++){
            System.out.println(n+" * "+i +" = "+n*i);
        }
    }
    public static void main(String[] args){
        //printTable(10);
        printTableRec(10, 1);
    }

    static void printTableRec(int n, int i){
        if(i == 11){
            return;
        }
        System.out.println(n+" * "+i +" = "+n*i);
        printTableRec(n, i+1);
    }
}

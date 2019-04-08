package dynamic_programming.recursion;

public class Qusetion_1_2_Add_Sum_Of_All_Previous_Numbers_to_Each_Index {
    public static void updateArray(int a[], int index){
        if(index == a.length){
            return;
        }
        else if(index > 0) {
            a[index] = a[index] + a[index - 1];
        }
        index++;
        updateArray(a, index);
    }
    public static void main(String[] args){
        int a[]= {1,2,3,4,5,6};
        updateArray(a, 0);
        printArray(a);
    }

    private static void printArray(int[] a) {
        for (int x: a){
            System.out.print(x+" ");
        }
    }
}

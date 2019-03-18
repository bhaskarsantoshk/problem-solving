package karumanchi.recursion_and_backtracking;

public class CheckSortedArrayRec {
    public int isArrayInSortedOrder(int[] A, int index){
        if(A.length == 1 || index==1){
            return 1;
        }
        return (A[index-1] < A[index-2])? 0 : isArrayInSortedOrder(A, index-1);
    }

    public static void main(String[] args){
        int a[] ={1,2,7,4,5};
        CheckSortedArrayRec obj = new CheckSortedArrayRec();
        int x= obj.isArrayInSortedOrder(a, 5);
        System.out.println(x);
    }
}

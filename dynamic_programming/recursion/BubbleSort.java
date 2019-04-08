package dynamic_programming.recursion;

public class BubbleSort {
    void bubbleSort(int[] a , int n){
        for(int i=0; i< n ; i++){
            for(int j=0; j<n-i-1;j++){
                if(a[j] > a[j+1]){
                    swap(a, j, j+1);
                }
            }
        }
    }

    static void bubbleSortRec(int a[] , int n){
        if(n==0){
            return;
        }
        for(int i=0;i<n-1;i++){
            if(a[i]>a[i+1]){
                swap(a, i, i+1);
            }
        }
        bubbleSortRec(a, n-1);
    }

    public static void main(String[] args){
        int a[] = {2,3,1,4};
        bubbleSortRec(a,4);
        for(int x: a){
            System.out.print(x+" ");
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp= a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

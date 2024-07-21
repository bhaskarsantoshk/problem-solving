package standard_algorithms.Sorting;

public class Sorting {

    public static void main(String[] args){
        int a[]= {5,2,3,1};
        Sorting sort = new Sorting();
        sort.quicksort(a, 0, a.length-1);

    }

    public static  void printArray(int a[]){
        for(int i=0; i<a.length; i++){
            System.out.print(a[i] +" ");
        }
    }
    public void quicksort(int array[], int start, int end){
        if(start < end) {
            int partitionIndex = partition(array, start, end);
            System.out.println("PI : " + partitionIndex);
            //printArray(array);
            //System.out.println();
            quicksort(array, start, partitionIndex - 1);
            quicksort(array, partitionIndex + 1, end);
        }
    }

    private int partition(int[] array, int start, int end) {
        int pIndex = start;
        int pivot = array[end];
        for(int i= start ; i<=end-1; i++){
            if(array[i] <= pivot){
                swap(array, i, pIndex);
                pIndex+=1;
            }
        }
        swap(array, pIndex, end);
        return pIndex;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}


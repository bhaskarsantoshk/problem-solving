package standard_algorithms;

public class Sorting {
    public void quicksort(int array[], int start, int end){
        if(start < end) {
            int partitionIndex = partition(array, start, end);
            quicksort(array, start, partitionIndex - 1);
            quicksort(array, partitionIndex + 1, end);
        }
    }

    private int partition(int[] array, int start, int end) {
        int pIndex = start;
        int pivot = array[end];
        for(int i= start ; i<end-1; i++){
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


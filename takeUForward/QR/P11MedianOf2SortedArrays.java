package takeUForward.QR;

public class P11MedianOf2SortedArrays {
    public double median(int[] arr1, int[] arr2) {
        int n = arr1.length+arr2.length;
        int index2 = n/2;
        int index1= index2-1;
        int element1 = -1, element2=-1;
        int count = 0;
        int i=0, j=0;
        while ( i < arr1.length && j < arr2.length) {
            if ( arr1[i] < arr2[j]) {
                if (count == index1) element1 = arr1[i];
                if (count == index2) element2 = arr1[i];
                i++;
                count++;
            } else {
                if (count == index1) element1 = arr2[j];
                if (count == index2) element2 = arr2[j];
                j++;
                count++;
            }
        }
        while ( i < arr1.length){
            if (count == index1) element1 = arr1[i];
            if (count == index2) element2 = arr1[i];
            i++;
            count++;
        }
        while ( j < arr2.length){
            if (count == index1) element1 = arr2[j];
            if (count == index2) element2 = arr2[j];
            j++;
            count++;
        }

        return n%2 == 1 ? element2: (double)((double)(element1+element2)/2.0);
    }
}

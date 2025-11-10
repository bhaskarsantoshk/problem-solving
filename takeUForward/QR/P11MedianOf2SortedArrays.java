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

    public double medianBinarySearch(int[] arr1, int[] arr2) {
        if ( arr1.length > arr2.length ) return medianBinarySearch(arr2, arr1);

        int len1 = arr1.length;
        int len2 = arr2.length;

        int n = len1+len2;
        int low = 0, high = len1;
        int left = (len1+len2+1)/2;

        while ( low <= high){
            int mid1 = (low+high) >> 1 ;
            int mid2 = left-mid1;

            int l1= Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1= Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if ( mid1 < len1) r1 = arr1[mid1];
            if ( mid2 < len2) r2 = arr2[mid2];

            if ( mid1-1 >= 0 ) l1 = arr1[mid1-1];
            if ( mid2-1 >=0 ) l2 = arr2[mid2-1];

            if ( l1 <= r2 && l2 <= r1){
                if ( n % 2 == 1) return Math.max(l1, l2);
                else return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            } else if (l1 > r2) high = mid1-1;
            else low = mid1+1;
        }
        return 0;
    }
}

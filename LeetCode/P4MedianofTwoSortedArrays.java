package LeetCode;

import java.awt.*;

public class P4MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] a, int[] b) {
       if(a.length > b.length){
           return findMedianSortedArrays(b,a);
       }
       int x = a.length;
       int y = b.length;

       int low = 0;
       int high = x;

       while (low <= high){
           int partitionX = (low + high)/2;
           int partitionY = (x+y+1)/2 - partitionX;
           int maxLeftX = (partitionX==0) ? Integer.MIN_VALUE :a[partitionX-1];
           int minRightX = (partitionX==x) ? Integer.MAX_VALUE : a[partitionX];
           int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : b[partitionY-1];
           int minRightY = (partitionY==y) ? Integer.MAX_VALUE : b[partitionY];

           if(maxLeftX <= minRightY && maxLeftY <= minRightX){
               if((x+y) % 2== 0){
                   return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2.0;
               }
               else{
                   return (double)Math.max(maxLeftX, maxLeftY);
               }
           }
           else if( maxLeftX > minRightY){
               high = partitionX-1;
           }
           else{
               low= partitionX+1;
           }
       }
       return -1;
    }
}

package LeetCode;

import java.util.Random;

public class P384ShuffleanArray {
    int [] nums;
    Random random;
    public P384ShuffleanArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
     int [] newarray= nums.clone();
     for(int j=1;j<newarray.length; j++){
         int i= random.nextInt(j+1);
         swap(newarray, i , j);
     }
     return newarray;
    }

    private void swap(int[] newarray, int i, int j) {
        int temp = newarray[i];
        newarray[i]=newarray[j];
        newarray[j]=temp;
    }
}

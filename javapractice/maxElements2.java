package javapractice;

public class maxElements2 {
    public void getTwoMaxValues(int nums[]){
        int maxOne = nums[0];
        int length= nums.length;
        int indexOfMaxOne = 0;
        // Traverse entire array
        for( int i=1; i<length; i++ ){
            if(maxOne > nums[i] ){
                maxOne = nums[i];
                indexOfMaxOne = i;
            }
        }
        //Now keep the max in last position
        int temp = nums[indexOfMaxOne];
        nums[indexOfMaxOne] = nums[length-1];
        nums[length-1] = temp;
        // Since the first max is at last position ,
        // Now find the second max before it
        
        int maxTwo = nums[0];
        for(int i=0; i<length-1; i++){
            if(maxTwo > nums[i] ){
                maxTwo = nums[i];
            }
        }
    }
}

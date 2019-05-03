package LeetCode;

public class P238ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        left[0]=1;
        right[nums.length-1]=1;
        for(int i=1; i<nums.length; i++){
            left[i]= left[i-1] * nums[i-1];
        }
        for(int j=nums.length-2; j>=0; j--){
            right[j]= right[j+1] * nums[j+1];
        }
        printArray(left);
        printArray(right);
        int result[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            result[i]= left[i] * right[i];
        }
        return result;
    }

    private static void printArray(int [] a){
        for(int x: a){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int a[] = {1,2,3,4};
        P238ProductofArrayExceptSelf obj = new P238ProductofArrayExceptSelf();
        printArray(obj.productExceptSelf(a));
    }
}

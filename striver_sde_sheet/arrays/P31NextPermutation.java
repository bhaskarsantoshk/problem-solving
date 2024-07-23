package striver_sde_sheet.arrays;

public class P31NextPermutation {
    // Bruteforce
    // Generate all possible permutations
    // Sort them
    // Use Linear search to find the current permutation
    // return next
    // if it's the last, return first
    // T O ( N!)

    // STL next_permutation()

    // prefix matching
    // typically next perm matches with max long prefix
    // so try to find the index where the next perm differs
    // 2 1 5 4 3 0 0 ( can I modify last 2 digits ? no, 00
    // 2 1 5 4 3 0 0 ( can I modify last 3 digits ? no, 003, 030 don't come next)
    // 2 1 5 4 3 0 0 ( can I modify last 4 digits ? no, 3400, 3004, 0043 etc don't come next -  cause you have 4, you need someone greater than 5)
    // 2 1 5 4 3 0 0 ( can I modify last 5 digits ? no, 53400, 53004, 50043, 54300 etc don't come next - cause you have 5, you need someone greater than 5)
    // 2 1 5 4 3 0 0 ( can I modify last 6 digits ? yes, 514300, 543100, etc do come next)
    // since you needed a num > 1 but not very very greater , look for that num.
    // that is 3
    // 2 3 5 4 1 0 0
    // 2 3 ( to keep this thing as small as possible - sorted order )
    // 2 3 5 4 1 0 0 ( once you swap, it will still be in creasing order )
    // 2 3 reverse the rest
    // 2 3 0 0 1 4 5

    // Algo
    // Longer prefix match , find a break point a[i] < a[i+1]
    // find someone greater than the number at break point
    // smallest of greater ( closest)


    public void nextPermutation(int[] nums) {
        int breakPoint = -1;
        for ( int i= nums.length-2; i>=0; i--){
            if ( nums[i] < nums[i+1]){
                breakPoint = i;
                break;
            }
        }

        if ( breakPoint == -1){
            reverse(nums, 0, nums.length-1);
            return;
        }

        for ( int i=nums.length-1; i>=0; i--){
            if ( nums[i] > nums[breakPoint]){
                int temp = nums[i];
                nums[i] = nums[breakPoint];
                nums[breakPoint] = temp;
                break;
            }
        }
        reverse(nums, breakPoint+1, nums.length-1);
    }

    private void reverse(int a[], int start, int end){
        while ( start < end){
            int temp = a[start];
            a[start++] = a[end];
            a[end--] = temp;
        }
    }
}

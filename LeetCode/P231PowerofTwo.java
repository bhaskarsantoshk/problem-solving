package LeetCode;

public class P231PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if(n==1) return true;
        if(n<1) return false;
        return (n & n-1) == 0;
    }
}

package LeetCode;

public class P461HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}

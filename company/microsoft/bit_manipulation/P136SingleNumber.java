package company.microsoft.bit_manipulation;

public class P136SingleNumber {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int num: nums) xor ^= num;
        return xor;
    }
}

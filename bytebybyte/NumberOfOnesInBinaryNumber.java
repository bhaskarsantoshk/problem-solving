package bytebybyte;

public class NumberOfOnesInBinaryNumber {
    public int countOnes(int x){
        int count = 0;
        while ( x > 0){
            count += x & 1;
            x = x >> 1;
        }
        return count;
    }
}

// 3 -> 0b11 = 2
// 4 -> 0b100 = 1
// go through number bit by bit and count the all
// extract lowest order bit at any given time, shift right so we get the next lowest order bit
// you can check if the lowest order bit is one or zero by doing mod 2,  or we could x & 1

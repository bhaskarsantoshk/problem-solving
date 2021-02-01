package bytebybyte;

public class GrayNumber {

    public static boolean isGray(int a, int b){
        int xor = a ^ b;
        while ( xor > 0){
            if ( xor % 2 == 1 && xor>>1 >0){
                return false;
            }
            xor = xor >>1;
            // left shift means multiply by 2, right shift is divided by 2
        }

        // trick to avoid while loop- (x & x-1) =0 for x if it's power of 2
        // entire while loop can be replaced with return (x & (x-1)) == 0
        return true;
    }

    public static void main(String[] args){
        System.out.println(isGray(1,0));
    }

}

// check if two integers are grey code to each to each other - means differ by one bit

// 0b00
// 0b01
// True

// 01
// 10
// False

// 0b010101
// 0b000101
// True

/*
From the example, it's clear that the xor is always gonna be a power of 2, as there will be only one bit difference

 */
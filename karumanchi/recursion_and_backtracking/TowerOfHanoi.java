package karumanchi.recursion_and_backtracking;

public class TowerOfHanoi {
    public void TowersOfHanoi(int n, char frompeg, char topeg, char auxpeg){
        // If only one disk , make the move and return
        if(n == 1){
            System.out.println("Move disc 1 from peg "+frompeg+" to peg "+topeg);
        }
        //Move Top n-1 discs from A to B using C as aux
        TowersOfHanoi(n-1, frompeg, auxpeg, topeg);
        //Move remaining disc from A to C
        System.out.println("Move disc from peg "+frompeg+" to peg "+topeg);
        //Move n-1 discs from B to C using A as aux
        TowersOfHanoi(n-1, auxpeg, topeg, frompeg);
    }
}
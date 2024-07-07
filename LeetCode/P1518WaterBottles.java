package LeetCode;

public class P1518WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while ( numBottles >= numExchange){
            res += (numBottles/numExchange);
            numBottles = numBottles /numExchange + numBottles % numExchange;
        }
        return res;
    }
}

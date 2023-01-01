package competitive_programming.codechef;

import java.util.Scanner;

public class BUYPLSE {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner in = new Scanner(System.in);
        int numOfPens = in.nextInt();
        int numOfPensils = in.nextInt();
        int priceOfPen = in.nextInt();
        int priceOfPensil = in.nextInt();
        System.out.println(numOfPens * priceOfPen + numOfPensils * priceOfPensil);
    }
}

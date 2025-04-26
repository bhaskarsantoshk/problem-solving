package takeUForward.bitManipulation;

public class P14SingleNumberII {
    public static int elementThatAppearsOnce(int[] arr)
    {
        int ans = 0;
        for ( int bitIndex=0; bitIndex<31; bitIndex++){
          int count =0;
          for ( int num: arr){
              if ( (num & (1 <<bitIndex)) != 0) count++;
          }
          if ( count % 3 == 1){
             ans = ans | ( 1 << bitIndex);
          }
        }
        return ans;
    }

    public static int elementThatAppearsOncOptimzede(int[] arr)
    {
        int ones = 0, twos=0;
        for ( int i=0; i<arr.length; i++){
            ones = (ones ^ arr[i]) & ~twos;
            twos = (twos ^ arr[i]) & ~ones;
        }
        return ones;
    }
}

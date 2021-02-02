package bytebybyte;

public class SwapVariables {

    public void swap1(int x, int y){
        x = x+y;
        y = x-y;
        x = x-y;
    }

    public void swap2(int x, int y){
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
    }

}
// do not use any temporary variable

// swap ([x,y]) -> [y,x]
//or
// simply print x and y with swapped values

/*
general solution : using a temp - we need to avoid this

approach 1: a = a+b, b = a-b, a=a-b
approach 2: a = a^b, b = a^b, a= a^b
 */

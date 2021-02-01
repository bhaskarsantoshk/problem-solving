package bytebybyte;

class FizzBuzz{
    public static void fizzBuzz(int x){
        for ( int i=1; i<=x; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                print("FizzBuzz");
            }
            else if (i % 3 == 0){
                print("Fizz");
            }
            else if(i % 5 == 0){
                print("Buzz");
            }
            else{
                print(String.valueOf(i));
            }
        }
    }

    private static void print(String str) {
        System.out.println(str);
    }

    public static void main(String[] args){
        fizzBuzz(15);
    }
}
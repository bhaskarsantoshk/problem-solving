package technologies.java.object_oriented_programming;

public class Demo {
    public static void main(String args[]) {
        Calculator obj = new Calculator(10, 94);

        System.out.println(obj.add());
        System.out.println(obj.subtract());
        System.out.println(obj.multiply());
        System.out.println(obj.divide());
    }
}

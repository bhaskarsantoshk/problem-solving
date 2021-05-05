package technologies.java.object_oriented_programming;

public class Calculator {
    private double num1;
    private double num2;

    public Calculator(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    double add() {
        return this.num1+this.num2;
    }

    double subtract() {
        return this.num1 - this.num2;
    }

    double multiply() {
        return this.num1 * this.num2;
    }

    double divide() {
        return this.num1/this.num2;
    }
}

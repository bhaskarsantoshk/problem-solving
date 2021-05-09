package technologies.java.object_oriented_programming.polymorphism;

class Shape {
    public double getArea(){
        return 0;
    }
}

class Square extends Shape{
    private double side;

    public Square(double side){
        this.side = side;
    }

    public double getArea(){
        return side * side;
    }
}

class Circle extends Shape {
    private  double radius;
    public Circle(double radius){
        this.radius = radius;
    }
    public double getArea(){
        return Math.PI * radius * radius;
    }
}

class Main{
    public static void main(String[] args){
        Circle circle = new Circle(5);
        System.out.println(circle.getArea());

        Square square = new Square(5);
        System.out.println(square.getArea());
    }
}

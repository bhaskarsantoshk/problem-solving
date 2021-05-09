package technologies.java.object_oriented_programming.dynamic_polymorphism;

class Shape {
    public double getArea(){
        return 0;
    }
}

class Square extends Shape {
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
        Shape [] shapes = new Shape[2];
        shapes[0] = new Circle(5);
        shapes[1] = new Square(5);
        for ( Shape shape: shapes){
            System.out.println(shape.getArea());
        }
    }
}

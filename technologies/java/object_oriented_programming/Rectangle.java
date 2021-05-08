package technologies.java.object_oriented_programming;

 class Rectangle {
    private int length;
    private int width;
    public Rectangle () {
        this.length = 0;
        this.width = 0;
    }
    public Rectangle(int length, int width){
        this.length = length;
        this.width = width;
    }
    public int getArea(){
        return this.length * this.width;
    }
}

class Area{
    public static void main(String[] args){
        Rectangle rectangle = new Rectangle(5,4);
        System.out.println(rectangle.getArea());
    }
}

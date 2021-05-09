package technologies.java.object_oriented_programming.inheritence;

 class Vehicle {
     private String make;
     private String color;
     private int year;
     private String model;

     public Vehicle( String make, String color, int year, String model){
         this.make = make;
         this.color = color;
         this.year = year;
         this.model = model;
     }

     public void printDetails() {
         System.out.println("Manufacturer: " + make);
         System.out.println("Color: " + color);
         System.out.println("Year: " + year);
         System.out.println("Model: " + model);
     }
}

class Car extends Vehicle{

     private String bodyStyle;

     public Car(String make, String color, int year, String model, String bodyStyle) {
        super(make, color, year, model);
        this.bodyStyle = bodyStyle;
    }

    public void printCarDetails(){
         printDetails();
         System.out.println("Body style: "+ bodyStyle);
    }
}

class CarDemo{
     public static void main(String[] args){
         Car telsaModeX = new Car("Tesla", "Red", 2021, "Model X", "Sedan");
         telsaModeX.printCarDetails();
     }
}

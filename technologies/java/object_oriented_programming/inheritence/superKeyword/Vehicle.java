package technologies.java.object_oriented_programming.inheritence.superKeyword;

class Vehicle {
 int fuelCap = 90;

    public void display() {
        System.out.println("I am from the Vehicle Class");
    }
}

class Car extends Vehicle{
    int fuelCap = 50;
    public void displayFuel(){
        System.out.println("Fuel Capacity from the Vehicle class: " + super.fuelCap);
        System.out.println("Fuel Capacity from the Car class: " + fuelCap);
    }

    public void display() {
        System.out.println("I am from the Car Class");
    }

    public void printDisplay(){
        System.out.println("The display() call with super:");
        super.display();  //calling the display() of Vehicle(SuperClass)
        System.out.println("The display() call without super:");
        display();        //calling the display() of the Car(SubClass)
    }
}

class Fuel{
    public static void main(String[] args){
        Car tesla = new Car();
        tesla.displayFuel();
    }
}

class Display{
    public static void main(String[] args){
        Car telsa = new Car();
        telsa.printDisplay();
    }
}

package technologies.java.object_oriented_programming.inheritence.multi_level;

class Vehicle {
    private int topSpeed;

    public void setTopSpeed(int speed) {
        this.topSpeed=speed;
        System.out.println("The top speed is set to: "+ topSpeed);
    }
}
class Car extends Vehicle {

    public void openTrunk() {
        System.out.println("The Car trunk is Open Now!");
    }

}

class Tesla extends Car {

    public void turnOnHybrid() {
        System.out.println("The Hybrid mode is turned on!");
    }

}






 class Vehicle{
    String model;
    String year;
    Vehicle(String model, String year){
        this.model = model;
        this.year = year;
    }
    public void display(){
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}
 class Car extends Vehicle{
    String color;
    Car(String model, String year, String color){
        super(model, year);
        this.color = color;
    }@Override
    public void display(){
        // super.display();
        System.out.println("Color: " + color);
    }
}
public class Inheritence {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "2020", "Red");
        car.display();
    }
}

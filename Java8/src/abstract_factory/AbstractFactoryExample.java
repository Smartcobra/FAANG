package abstract_factory;

public class AbstractFactoryExample {
    public static void main(String[] args) {
        // Create a car
        VehicleFactory carFactory = new CarFactory();

        Wheel carWheel = carFactory.createWheel();
        Engine carEngine = carFactory.createEngine();
        Seat carSeat = carFactory.createSeat();

        carWheel.create();   // Creating car wheels
        carEngine.create();  // Creating car engine
        carSeat.create();    // Creating car seats

        System.out.println("\nSwitching to truck...");

        // Create a truck
        VehicleFactory truckFactory = new TruckFactory();

        Wheel truckWheel = truckFactory.createWheel();
        Engine truckEngine = truckFactory.createEngine();
        Seat truckSeat = truckFactory.createSeat();

        truckWheel.create();  // Creating truck wheels
        truckEngine.create(); // Creating truck engine
        truckSeat.create();   // Creating truck seats
    }
}

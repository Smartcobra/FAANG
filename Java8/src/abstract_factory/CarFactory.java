package abstract_factory;

public class CarFactory implements VehicleFactory {
    public Wheel createWheel() {
        return new CarWheel();
    }

    public Engine createEngine() {
        return new CarEngine();
    }

    public Seat createSeat() {
        return new CarSeat();
    }
}

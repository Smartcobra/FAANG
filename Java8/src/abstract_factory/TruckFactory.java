package abstract_factory;

public class TruckFactory implements VehicleFactory {
    public Wheel createWheel() {
        return new TruckWheel();
    }

    public Engine createEngine() {
        return new TruckEngine();
    }

    public Seat createSeat() {
        return new TruckSeat();
    }
}

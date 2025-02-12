package abstract_factory;

public interface VehicleFactory {
    Wheel createWheel();
    Engine createEngine();
    Seat createSeat();
}

package abstract_factory;

public class TruckSeat implements Seat{
    @Override
    public void create() {
        System.out.println("Creating truck seats");
    }
}

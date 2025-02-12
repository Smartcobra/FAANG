package abstract_factory;

public class TruckWheel implements Wheel{
    @Override
    public void create() {
        System.out.println("Creating truck wheels");
    }
}

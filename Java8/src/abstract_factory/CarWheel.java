package abstract_factory;

public class CarWheel implements Wheel{
    @Override
    public void create() {
        System.out.println("Creating car wheels");
    }
}
